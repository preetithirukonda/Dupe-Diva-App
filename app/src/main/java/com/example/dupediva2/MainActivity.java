package com.example.dupediva2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.dupediva2.databinding.ActivityMainBinding;
import com.example.dupediva2.ui.util.KeyFileLoader;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.api.gax.core.CredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.FaceAnnotation;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageAnnotatorSettings;
import com.google.cloud.vision.v1.LocalizedObjectAnnotation;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ImageView imageView;
    private ImageAnnotatorClient visionClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Initialize Google Cloud Vision API client
        CredentialsProvider credentialsProvider = () -> {
            try (InputStream inputStream = KeyFileLoader.loadKeyFileInputStream(this)) {
                Credentials credentials = GoogleCredentials.fromStream(inputStream);
                return credentials;
            } catch (IOException e) {
                // Handle exception
                return null;
            }
        };

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create(
                ImageAnnotatorSettings.newBuilder()
                    .setCredentialsProvider(credentialsProvider)
                    .build()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Button analyzeButton = findViewById(R.id.analyzeButton);
        // Example: Perform image analysis when a button is clicked
        analyzeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ByteString imageBytes = getImageBytesFromImageView(imageView);

                // Perform image analysis
                performImageAnalysis(imageBytes);
            }
        });

    private ByteString getImageBytesFromImageView(ImageView imageView) {
        // In a real app, you would convert the image in the ImageView to a ByteString
        // For demonstration purposes, this method just returns an empty ByteString
        //return ByteString.EMPTY;
    }

    private void performImageAnalysis(ByteString imageBytes) {
        if (imageBytes.isEmpty()) {
            Toast.makeText(this, "No image to analyze", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create AnnotateImageRequest with the image data
        Image image = Image.newBuilder().setContent(imageBytes).build();
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder().setImage(image).build();
        List<AnnotateImageRequest> requests = new ArrayList<>();
        requests.add(request);

        // Perform image analysis request
        try {
            List<AnnotateImageResponse> responses = visionClient.batchAnnotateImages(requests).getResponsesList();

            // Process the responses (e.g., extract labels, faces, etc.)
            processImageAnalysisResponses(responses);
        } catch (Exception e) {
            throw e;
        }
    }
    private void processImageAnalysisResponses(List<AnnotateImageResponse> responses) {
        if (responses.isEmpty()) {
            Toast.makeText(this, "No analysis results found", Toast.LENGTH_SHORT).show();
            return;
        }
        // Process each response
        for (AnnotateImageResponse response : responses) {
            // Extract relevant information from the response
            List<EntityAnnotation> labels = response.getLabelAnnotationsList();
            List<LocalizedObjectAnnotation> objects = response.getLocalizedObjectAnnotationsList();
            List<FaceAnnotation> faces = response.getFaceAnnotationsList();

            // Update the UI accordingly based on the extracted information
            if (!labels.isEmpty()) {
                // Update UI to display labels
                StringBuilder labelStringBuilder = new StringBuilder("Labels:\n");
                for (EntityAnnotation label : labels) {
                    labelStringBuilder.append(label.getDescription()).append("\n");
                }
                // Example: textView.setText(labelStringBuilder.toString());
            }

            if (!objects.isEmpty()) {
                // Update UI to display localized objects
                StringBuilder objectStringBuilder = new StringBuilder("Objects:\n");
                for (LocalizedObjectAnnotation object : objects) {
                    objectStringBuilder.append(object.getName()).append("\n");
                }
                // Example: textView.setText(objectStringBuilder.toString());
            }

            if (!faces.isEmpty()) {
                // Update UI to display faces
                StringBuilder faceStringBuilder = new StringBuilder("Faces:\n");
                for (FaceAnnotation face : faces) {
                    // You can extract information like face bounds, emotions, etc.
                    faceStringBuilder.append("Face bounds: ").append(face.getBoundingPoly()).append("\n");
                    // Example: faceStringBuilder.append("Joy likelihood: ").append(face.getJoyLikelihood()).append("\n");
                }
                // Example: textView.setText(faceStringBuilder.toString());
            }

            // Add more logic to process other types of annotations as needed
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the Vision API client when the activity is destroyed to release resources
        if (visionClient != null) {
            try {
                visionClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}

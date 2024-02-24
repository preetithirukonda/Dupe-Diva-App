package com.example.dupediva2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UploadImageActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageView;
    private Button uploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);

        imageView = findViewById(R.id.imageView);
        uploadButton = findViewById(R.id.uploadButton);

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a file picker or camera intent to allow the user to select or capture an image
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            // Handle the selected image
            Uri imageUri = data.getData();
            imageView.setImageURI(imageUri);

            // Call a method to send the image data to the Google Cloud Vision API for analysis
            sendImageToCloudVision(imageUri);
        }
    }

    private void sendImageToCloudVision(Uri imageUri) {
        // TODO: Implement logic to send image data to Google Cloud Vision API
        // You'll need to make an HTTP request to the API endpoint
        // Here's where you'll handle network operations and receive the response
    }

}

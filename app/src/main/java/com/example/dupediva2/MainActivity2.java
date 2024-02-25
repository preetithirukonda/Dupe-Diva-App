package com.example.dupediva2;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.dupediva2.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {
    //   ImageView imageView = findViewById(R.id.finalImage);
    private ActivityMainBinding binding;
    //   ActivityResultLauncher<Intent> resultLauncher;
    boolean loggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


        final Button loginButton = findViewById(R.id.myAccount);
        loginButton.setBackgroundColor(Color.parseColor("#F8C7C6"));

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openLoginActivity();
            }
        });


        final ImageButton camera = findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 3);

            }
        });

        final ImageButton upload = findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 3);

            }
        });

        //registerResult();
        // upload.setOnClickListener(view -> pickImage());
        if (loggedIn) {
            CharSequence ch = "My Account";
            loginButton.setText(ch);
        } else {
            CharSequence ch2 = "Login";
            loginButton.setText(ch2);
        }
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            AnalyzePage.setImage(selectedImage);
            Intent intent = new Intent(this, AnalyzePage.class);
            startActivity(intent);
            // ImageView imageView = findViewById(R.id.imageView);
            //   imageView.setImageURI(selectedImage);
        }
    }

    private void openLoginActivity() {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }


}
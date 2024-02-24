package com.example.dupediva2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.dupediva2.ui.login.LoginActivity;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Button userButton = findViewById(R.id.Welcome_User);
        userButton.setBackgroundColor(Color.parseColor("#F8C7C6"));

        userButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //openUserActivity();
            }
        });
    }


}
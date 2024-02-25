package com.example.dupediva2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dupediva2.R.id;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        final Button loginAndRegister = findViewById(id.loginAndRegister);
        loginAndRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMainActivity();
            }
        });

    }

    private void openMainActivity() {

        MainActivity m = new MainActivity();
        m.setLoggedIn(true);
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
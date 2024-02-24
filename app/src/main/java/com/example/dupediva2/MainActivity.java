package com.example.dupediva2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.dupediva2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

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


        final Button loginButton = findViewById(R.id.Login);
        loginButton.setBackgroundColor(Color.parseColor("#F8C7C6"));
      //  EditText e1 = (EditText) findViewById(R.id.textView);//Make Sure that this is EditText or TextView
    //    EditText e2 = (EditText) findViewById(R.id.textView2);
      //  TextView t1 = (EditText) findViewById(R.id.textView3);
        //int num1 = Integer.parseInt(e1.getText().toString());
        //int num2 = Integer.parseInt(e2.getText().toString());
       // int sum = num1 + num2;
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
          //      t1.setText(Integer.toString(sum));
            }
        });
    }


}
package com.example.dupediva2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        //      TextView textView = (TextView) findViewById(R.id.scrolltext1);
        //    textView.setText("hi");
        String filePath = "/data/user/0/com.example.dupediva2/files/output.json"; // Use the actual path
        try {
            ParseJSON data = new ParseJSON(filePath);
            TextView textView = (TextView) findViewById(R.id.scrolltext1);
            textView.setText("hi");
            try {
                Log.d("GOOD DATA OUTPUT", data.getTitle().get(0));
            } catch (Exception e) {
                Log.d("BAD DATA OUTPUT", "no");

                Log.d("GOOD DATA OUTPUT", Integer.toString(data.getTitle().size()));

            }
            //   textView.setText(data.getTitle().get(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
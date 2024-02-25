package com.example.dupediva2;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ObjectMapper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dupediva2.ui.login.LoginActivity;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AnalyzePage extends AppCompatActivity {
    ImageView imageView;
    static Uri uri;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze_page);

        imageView = findViewById(R.id.finalImage);
        imageView.setImageURI(uri);
        search = findViewById(R.id.searchButton);

        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                searchShopping();
            }
        });


    }

    public static void setImage(Uri img) {
        uri = img;
    }

    public void searchShopping() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();

                String apiKey = "b648ab9051dae38edb8a8e7ec05fd30e0e9b5b9bc4f58fa8ebc46f54bb57083b";
                String searchQuery = "grey-denim-pants";
                String apiUrl = "https://serpapi.com/search.json?engine=google_shopping&api_key=" + apiKey + "&q=" + searchQuery;

                try {
                    URL url = new URL(apiUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    final String jsonResponse = response.toString();
                    final String newJson = jSonReformat(jsonResponse);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            writeJsonToFile(newJson);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void writeJsonToFile2(String jsonResponse) {
        if (jsonResponse != null) {
            String filename = "output.json";
            try (FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE)) {
                fos.write(jsonResponse.getBytes());
                Toast.makeText(AnalyzePage.this, "Successfully wrote JSON object to file", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(AnalyzePage.this, "Error fetching JSON data from API", Toast.LENGTH_SHORT).show();
        }
    }


    public String jSonReformat(String uglyString) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Object jsonObject = objectMapper.readValue(uglyString, Object.class);
            String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
            return prettyJson;
        } catch (Exception e) {
            Log.d("JACKSON", "DIDNT WORK");
            return uglyString;

        }
    }

    private void writeJsonToFile(String jsonResponse) {
        if (jsonResponse != null) {
            String filename = "output.json";
            try (FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE)) {
                fos.write(jsonResponse.getBytes());
                Toast.makeText(AnalyzePage.this, "Successfully wrote JSON object to file", Toast.LENGTH_SHORT).show();

                String filePath = new File(getFilesDir(), filename).getAbsolutePath();
                Log.d("File Path", filePath);
                Intent intent = new Intent(this, Results.class);
                startActivity(intent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(AnalyzePage.this, "Error fetching JSON data from API", Toast.LENGTH_SHORT).show();
        }
    }


}
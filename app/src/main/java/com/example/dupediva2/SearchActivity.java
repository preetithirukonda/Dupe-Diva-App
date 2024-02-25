package com.example.dupediva2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SearchActivity extends AppCompatActivity {
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search = findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                searchShopping();
            }
        });
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
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            writeJsonToFile(jsonResponse);
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
                Toast.makeText(SearchActivity.this, "Successfully wrote JSON object to file", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(SearchActivity.this, "Error fetching JSON data from API", Toast.LENGTH_SHORT).show();
        }
    }

    private void writeJsonToFile(String jsonResponse) {
        if (jsonResponse != null) {
            String filename = "output.json";
            try (FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE)) {
                fos.write(jsonResponse.getBytes());
                Toast.makeText(SearchActivity.this, "Successfully wrote JSON object to file", Toast.LENGTH_SHORT).show();

                String filePath = new File(getFilesDir(), filename).getAbsolutePath();
                Log.d("File Path", filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(SearchActivity.this, "Error fetching JSON data from API", Toast.LENGTH_SHORT).show();
        }
    }

}

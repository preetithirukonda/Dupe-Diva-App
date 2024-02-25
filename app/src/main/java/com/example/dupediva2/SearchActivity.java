package com.example.dupediva2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.FileWriter;
import java.io.IOException;

public class SearchActivity extends AppCompatActivity {

    Button search = findViewById(R.id.search);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Button search = findViewById(R.id.search);
        Button search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                searchShopping();
            }
        });
    }

    public void searchShopping() {
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
            try (FileWriter file = new FileWriter("output.json")) {
                gson.toJson(response, file);
                System.out.println("Successfully wrote JSON object to file");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
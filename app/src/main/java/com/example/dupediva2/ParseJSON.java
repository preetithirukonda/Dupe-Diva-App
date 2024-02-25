package com.example.dupediva2;

import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseJSON {
    private ArrayList<String> title;
    private ArrayList<String> link;
    private ArrayList<String> price;
    private ArrayList<String> thumbnail;

    public String file;
    public ParseJSON(String file) throws IOException {
        title = new ArrayList<>();
        link = new ArrayList<>();
        price = new ArrayList<>();
        thumbnail = new ArrayList<>();

        Scanner in = new Scanner(new FileInputStream(file));

        in.useDelimiter("\"");

        while(!in.nextLine().contains("shopping_results")){
            in.nextLine();
        }

        while(in.hasNextLine()) {
        //    Log.d("seeing lines", "yes");
            String line = in.nextLine();
            Log.d("seeing after filter", "yes");
            if(line.contains("\"title\": ")){
                Log.d("seeing title", "yes");
                title.add(line.substring(22, (line.length() - 2)));
            }
            if(line.contains("\"link\": ")) {
                Log.d("seeing link", "yes");
                link.add(line.substring(21, (line.length() - 2)));
            }
            if(line.contains("\"price\": ")){
                Log.d("seeing price", "yes");
                price.add(line.substring(22, (line.length() - 2)));
            }
            if(line.contains("\"thumbnail\": ")) {
                Log.d("seeing thumbnail", "yes");
                thumbnail.add(line.substring(26, (line.length() - 2)));
            }
        }

        in.close();
    }

    public ArrayList<String> getTitle(){
        return title;
    }

    public ArrayList<String> getLink(){
        return link;
    }

    public ArrayList<String> getPrice(){
        return price;
    }

    public ArrayList<String> getThumbnail(){
        return thumbnail;
    }
}

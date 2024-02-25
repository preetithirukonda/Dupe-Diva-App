package com.example.dupediva2;

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

        while(!in.nextLine().contains("shopping_results")){
            in.nextLine();
        }

        while(in.hasNextLine()) {
            String line = in.nextLine();
            if(line.contains("categories")) {
                break;
            }
            if(line.contains("\"title\"")){
                title.add(line.substring(15, (line.length() - 2)));
            }
            if(line.contains("\"link\"")) {
                link.add(line.substring(14, (line.length() - 2)));
            }
            if(line.contains("\"price\"")){
                price.add(line.substring(15, (line.length() - 2)));
            }
            if(line.contains("\"thumbnail\"")) {
                thumbnail.add(line.substring(19, (line.length() - 2)));
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

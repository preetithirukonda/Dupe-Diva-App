package com.example.dupediva2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.squareup.picasso.Picasso;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        //      TextView textView = (TextView) findViewById(R.id.scrolltext1);
        //    textView.setText("hi");
        String filePath = "/data/user/0/com.example.dupediva2/files/output.json"; // Use the actual path
        ArrayList<String> title = new ArrayList<>();
        ArrayList<String> link = new ArrayList<>();
        ArrayList<String> price = new ArrayList<>();
        ArrayList<String> thumbnail = new ArrayList<>();
        try {
            ParseJSON data = new ParseJSON(filePath);
            title = data.getTitle();
            link = data.getLink();
            price = data.getPrice();
            thumbnail = data.getThumbnail();
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

        //#2
        TextView textView2 = (TextView) findViewById(R.id.scrolltext2);
        textView2.setText(title.get(0));
        ImageView imageView2 = findViewById(R.id.imageButton2);
        String imageUrl2 = "https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcSGtwdSkRi9dFyVPN9LYFxC_QFfbhpsLp8OcaRsEQcBcHi0HHaRX-6elzpx4Z2HsehJ9KlNEVCxNbp0GFputFg69Cq3XcKjjEr4u4xcv_xLeyhU3lCMBaJssA&usqp=CAE";
        Picasso.get().load(imageUrl2).into(imageView2);

        System.out.println(title.get(0));
        System.out.println(link.get(0));
        System.out.println(price.get(0));
        System.out.println(thumbnail.get(0));

        TextView textView = (TextView) findViewById(R.id.scrolltext1);
        textView.setText(title.get(0));
    }
}
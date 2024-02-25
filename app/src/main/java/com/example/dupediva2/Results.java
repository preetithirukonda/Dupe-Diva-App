package com.example.dupediva2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
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

        //#1
        TextView textView = (TextView) findViewById(R.id.scrolltext1);
        textView.setText( title.get(0) + "\n" + price.get(0));
        ImageView imageView = findViewById(R.id.imageButton1);
        String imageUrl = thumbnail.get(0);
        Picasso.get().load(imageUrl).into(imageView);
        ImageButton b1 = findViewById(R.id.imageButton1);
        ArrayList<String> finalLink = link;
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(0)));
                startActivity(browserIntent);
            }
        });

        //#2
        TextView textView1 = (TextView) findViewById(R.id.scrolltext2);
        textView.setText( title.get(1) + "\n" + price.get(1));
        ImageView imageView1 = findViewById(R.id.imageButton2);
        String imageUrl1 = thumbnail.get(1);
        Picasso.get().load(imageUrl).into(imageView);
        ImageButton b2 = findViewById(R.id.imageButton2);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(1)));
                startActivity(browserIntent1);
            }
        });

        //#3
        TextView textView2 = (TextView) findViewById(R.id.scrolltext3);
        textView.setText( title.get(2) + "\n" + price.get(2));
        ImageView imageView2 = findViewById(R.id.imageButton3);
        String imageUrl2 = thumbnail.get(2);
        Picasso.get().load(imageUrl).into(imageView);
        ImageButton b3 = findViewById(R.id.imageButton3);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(2)));
                startActivity(browserIntent2);
            }
        });

        //#2
        TextView textView3 = (TextView) findViewById(R.id.scrolltext4);
        textView.setText( title.get(3) + "\n" + price.get(3));
        ImageView imageView3 = findViewById(R.id.imageButton4);
        String imageUrl3 = thumbnail.get(3);
        Picasso.get().load(imageUrl).into(imageView);
        ImageButton b4 = findViewById(R.id.imageButton4);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(3)));
                startActivity(browserIntent3);
            }
        });

        //#3
        TextView textView4 = (TextView) findViewById(R.id.scrolltext5);
        textView.setText( title.get(4) + "\n" + price.get(4));
        ImageView imageView4 = findViewById(R.id.imageButton5);
        String imageUrl4 = thumbnail.get(2);
        Picasso.get().load(imageUrl).into(imageView);
        ImageButton b5 = findViewById(R.id.imageButton5);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent4 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(4)));
                startActivity(browserIntent4);
            }
        });

        //#2
        TextView textView5 = (TextView) findViewById(R.id.scrolltext6);
        textView.setText( title.get(5) + "\n" + price.get(5));
        ImageView imageView5 = findViewById(R.id.imageButton6);
        String imageUrl5 = thumbnail.get(5);
        Picasso.get().load(imageUrl).into(imageView);
        ImageButton b6 = findViewById(R.id.imageButton6);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent5 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(5)));
                startActivity(browserIntent5);
            }
        });


    }
}
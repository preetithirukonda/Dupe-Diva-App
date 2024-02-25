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

import java.io.IOException;
import java.util.ArrayList;

import com.squareup.picasso.Picasso;

public class Results extends AppCompatActivity {
    static Uri uri;
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> link = new ArrayList<>();
    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> thumbnail = new ArrayList<>();
    ArrayList<Integer> intPrice = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ImageView img = findViewById(R.id.searchedImage);
        img.setImageURI(uri);
        //      TextView textView = (TextView) findViewById(R.id.scrolltext1);
        //    textView.setText("hi");
        String filePath = "/data/user/0/com.example.dupediva2/files/output.json"; // Use the actual path
        ArrayList<String> title = new ArrayList<>();
        ArrayList<String> link = new ArrayList<>();
        ArrayList<String> price = new ArrayList<>();
        ArrayList<String> thumbnail = new ArrayList<>();
        ArrayList<Double> intPrice = new ArrayList<>();
        try {
            ParseJSON data = new ParseJSON(filePath);
            title = data.getTitle();
            link = data.getLink();
            price = data.getPrice();
            thumbnail = data.getThumbnail();
            intPrice = data.getIntPrice();
            organizePrice(intPrice);
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
        textView.setText(title.get(0) + "\n" + price.get(0));
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
        textView1.setText(title.get(1) + "\n" + price.get(1));
        ImageView imageView1 = findViewById(R.id.imageButton2);
        String imageUrl1 = thumbnail.get(1);
        Picasso.get().load(imageUrl1).into(imageView1);
        ImageButton b2 = findViewById(R.id.imageButton2);
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(1)));
                startActivity(browserIntent1);
            }
        });

        //#3
        TextView textView2 = (TextView) findViewById(R.id.scrolltext3);
        textView2.setText(title.get(2) + "\n" + price.get(2));
        ImageView imageView2 = findViewById(R.id.imageButton3);
        String imageUrl2 = thumbnail.get(2);
        Picasso.get().load(imageUrl2).into(imageView2);
        ImageButton b3 = findViewById(R.id.imageButton3);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(2)));
                startActivity(browserIntent2);
            }
        });

        //#2
        TextView textView3 = (TextView) findViewById(R.id.scrolltext4);
        textView3.setText(title.get(3) + "\n" + price.get(3));
        ImageView imageView3 = findViewById(R.id.imageButton4);
        String imageUrl3 = thumbnail.get(3);
        Picasso.get().load(imageUrl3).into(imageView3);
        ImageButton b4 = findViewById(R.id.imageButton4);
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(3)));
                startActivity(browserIntent3);
            }
        });

        //#3
        TextView textView4 = (TextView) findViewById(R.id.scrolltext5);
        textView4.setText(title.get(4) + "\n" + price.get(4));
        ImageView imageView4 = findViewById(R.id.imageButton5);
        String imageUrl4 = thumbnail.get(2);
        Picasso.get().load(imageUrl4).into(imageView4);
        ImageButton b5 = findViewById(R.id.imageButton5);
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent4 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(4)));
                startActivity(browserIntent4);
            }
        });

        //#2
        TextView textView5 = (TextView) findViewById(R.id.scrolltext6);
        textView5.setText(title.get(5) + "\n" + price.get(5));
        ImageView imageView5 = findViewById(R.id.imageButton6);
        String imageUrl5 = thumbnail.get(5);
        Picasso.get().load(imageUrl5).into(imageView5);
        ImageButton b6 = findViewById(R.id.imageButton6);
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent5 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(5)));
                startActivity(browserIntent5);
            }
        });

        //#3
        TextView textView6 = (TextView) findViewById(R.id.scrolltext7);
        textView6.setText(title.get(6) + "\n" + price.get(6));
        ImageView imageView6 = findViewById(R.id.imageButton7);
        String imageUrl6 = thumbnail.get(6);
        Picasso.get().load(imageUrl6).into(imageView6);
        ImageButton b7 = findViewById(R.id.imageButton7);
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent6 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(6)));
                startActivity(browserIntent6);
            }
        });

        //#2
        TextView textView7 = (TextView) findViewById(R.id.scrolltext8);
        textView7.setText(title.get(7) + "\n" + price.get(7));
        ImageView imageView7 = findViewById(R.id.imageButton8);
        String imageUrl7 = thumbnail.get(7);
        Picasso.get().load(imageUrl7).into(imageView7);
        ImageButton b8 = findViewById(R.id.imageButton8);
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent7 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(7)));
                startActivity(browserIntent7);
            }
        });

        //#3
        TextView textView8 = (TextView) findViewById(R.id.scrolltext9);
        textView8.setText(title.get(8) + "\n" + price.get(8));
        ImageView imageView8 = findViewById(R.id.imageButton9);
        String imageUrl8 = thumbnail.get(8);
        Picasso.get().load(imageUrl8).into(imageView8);
        ImageButton b9 = findViewById(R.id.imageButton9);
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent8 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(8)));
                startActivity(browserIntent8);
            }
        });

        //#2
        TextView textView9 = (TextView) findViewById(R.id.scrolltext10);
        textView9.setText(title.get(9) + "\n" + price.get(9));
        ImageView imageView9 = findViewById(R.id.imageButton10);
        String imageUrl9 = thumbnail.get(9);
        Picasso.get().load(imageUrl9).into(imageView9);
        ImageButton b10 = findViewById(R.id.imageButton10);
        b10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent9 = new Intent(Intent.ACTION_VIEW, Uri.parse(finalLink.get(9)));
                startActivity(browserIntent9);
            }
        });

    }

    public static void organizePrice(ArrayList<Double> price) {
        for (int i = 0; i < price.size(); i++) {
            System.out.print(price.get(i));
        }
    }

    public static void setImage(Uri img) {
        uri = img;
    }
}
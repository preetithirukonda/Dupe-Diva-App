package com.example.dupediva2;

import static android.content.ClipData.newIntent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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
            //#1
            TextView textView = (TextView) findViewById(R.id.scrolltext1);
            textView.setText("Prettylittlething Women's Washed Grey Dipped Back Waistband Boyfriend Jeans - Size 6\n" + "$26.00");
            ImageView imageView = findViewById(R.id.imageButton1);
            String imageUrl = "https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcSGtwdSkRi9dFyVPN9LYFxC_QFfbhpsLp8OcaRsEQcBcHi0HHaRX-6elzpx4Z2HsehJ9KlNEVCxNbp0GFputFg69Cq3XcKjjEr4u4xcv_xLeyhU3lCMBaJssA&usqp=CAE";
            Picasso.get().load(imageUrl).into(imageView);
            ImageButton b1 = findViewById(R.id.imageButton1);
            b1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                    startActivity(browserIntent);
                }
            });

            //#2
            TextView textView2 = (TextView) findViewById(R.id.scrolltext2);
            textView2.setText("hi");
            ImageView imageView2 = findViewById(R.id.imageButton2);
            String imageUrl2 = "https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcSGtwdSkRi9dFyVPN9LYFxC_QFfbhpsLp8OcaRsEQcBcHi0HHaRX-6elzpx4Z2HsehJ9KlNEVCxNbp0GFputFg69Cq3XcKjjEr4u4xcv_xLeyhU3lCMBaJssA&usqp=CAE";
            Picasso.get().load(imageUrl2).into(imageView2);

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
package com.example.testokhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    static TextView mytext,mytext2;
   static ImageView imageView;
    public static HashMap<String,String> serverresponse = new HashMap<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("user","i am irfan");

        new Response("https://reqres.in/api/users/2",MainActivity.this);

         imageView = findViewById(R.id.Image);


        mytext =findViewById(R.id.newText);

        mytext2 =findViewById(R.id.newText1);



    }
    public static void fun(){
        mytext.setText(serverresponse.get("email"));

        Picasso.get().load(serverresponse.get("avatar")).into(imageView);
        mytext2.setText(serverresponse.get("first_name"));


    }
}

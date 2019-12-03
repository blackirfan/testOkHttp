package com.example.testokhttp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Response {

    HashMap<String,String> mymap;


    public Response(String url, Context context){



        Request request = new Request.Builder().url(url).build();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("not response","e");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull okhttp3.Response response) throws IOException {


                String data = response.body().string();

                Log.e("data is here",data);

                mymap=new HashMap<>();

                try{
                    JSONObject jsonObject;

                    //EKHANE json object neoya hoyeche

                    jsonObject = new JSONObject(data);
                    Log.e("here..",jsonObject.toString());
                    JSONObject jsonObject1 = jsonObject.getJSONObject("data");

                    mymap.put("id",jsonObject1.getString("id"));
                    mymap.put("email",jsonObject1.getString("email"));
                    mymap.put("first_name",jsonObject1.getString("first_name"));
                    mymap.put("last_name",jsonObject1.getString("last_name"));
                    mymap.put("avatar",jsonObject1.getString("avatar"));



                    Log.e("id",mymap.get("id"));
                    Log.e("email",mymap.get("email"));
                    Log.e("firstname",mymap.get("first_name"));
                    Log.e("lastname",mymap.get("last_name"));
                    Log.e("avatar",mymap.get("avatar"));






                }catch (JSONException e){
                    e.printStackTrace();


                }



                //main activity layout e print er jonno ei method use kora hoyese
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Toast.makeText(context,mymap.get("email"),Toast.LENGTH_SHORT).show();
//                        MainActivity.serverresponse = mymap.get("email");


                        MainActivity.serverresponse = mymap;



                        MainActivity.fun();
                    }

                });

            }
        });
    }
}

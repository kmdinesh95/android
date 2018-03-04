package com.dinesh.json_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {




    //the URL having the json data
    private static final String JSON_URL = "http://legalnote.org/forouruse/Dinesh/sample.php";

    //listview object
    ListView listView;

    //the hero list where we will store all the hero objects after parsing json
    List<Something> s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initializing listview and hero list
        listView = (ListView) findViewById(R.id.listView);
        s = new ArrayList<>();

        //this method will fetch and parse the data
        volley();
    }



    private void volley() {
        //getting the progressbar
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //making the progressbar visible
        progressBar.setVisibility(View.VISIBLE);

        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion
                        progressBar.setVisibility(View.INVISIBLE);


                        try {


                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);




                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray array = obj.getJSONArray("abc");



                            //now looping through all the elements of the json array
                            for (int i = 0; i < array.length(); i++) {



                                //getting the json object of the particular index inside the array
                                JSONObject obj1 = array.getJSONObject(i);

                                String a= obj1.getString("name");
                                String b=obj1.getString("imageurl");
                                String c =obj1.getString("age");


                                //creating a hero object and giving them the values from json object
                                Something s_obj = new Something(a,b,c);

                                //adding the hero to herolist
                                s.add(s_obj);

                            }

                            //creating custom adapter object
                            Listviewadapter adapter = new Listviewadapter (s,getApplicationContext());

                            //adding the adapter to listview
                            listView.setAdapter(adapter);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }
}


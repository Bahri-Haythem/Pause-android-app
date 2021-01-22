package com.example.pause;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class JsonParser {

    //static JSONObject jObj = null;
    static String json = "";

    // constructor
    public JsonParser() {

    }

    public static String makeRequest( String u )
    {
        Log.e("DEBUG ", "Making sure JSONParser.makeRequest is called");
        HttpURLConnection conn=null;

        // For debugging purposes, a unique try catch for any kind of exception
        try {
            URL url = new URL(u);
            conn= (HttpURLConnection) url.openConnection();

            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "iso-8859-1"), 8);

            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            json = sb.toString();
            //jObj = new JSONObject(json);

        } catch (Exception e){
            Log.e("DEBUG ", "Exception in makeRequest");
            e.printStackTrace();
        }
        return json;
    }
}

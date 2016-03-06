package com.example.trey.attempt2;

import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class TMapi {
    private Exception exception;

    protected void onPreExecute() {

    }

    protected static String doInBackground() {

        // Do some validation here

        try {
            String bobby = "worked";
            URL url = new URL("https://app.ticketmaster.com/discovery/v1/events.json?postalCode=90007&apikey=pGNwjKe1ggesYToqvem4wg7DgvyuInuV");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {

                return  (String) url.getContent();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return "fucked up";
        }
    }

    protected void onPostExecute(String response) {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }

        Log.i("INFO", response);

    }
}


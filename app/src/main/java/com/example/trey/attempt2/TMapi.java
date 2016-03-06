package com.example.trey.attempt2;

import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class TMapi {
    private Exception exception;

    protected void onPreExecute() {

    }

    protected static String doInBackground() {

        // Do some validation here

        try {
            URL url = new URL("https://app.ticketmaster.com/discovery/v1/events.json?postalCode=90007&apikey=pGNwjKe1ggesYToqvem4wg7DgvyuInuV");
            URLConnection discover = url.openConnection();
            try {
                /*BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                discover.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    response.append(inputLine);

                in.close();

                return response.toString();*/
                System.out.print(discover.getContent());
                return "hello";
            }
            finally {

            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return "messed up";
        }
    }

    protected void onPostExecute(String response) {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }

        Log.i("INFO", response);

    }
}


package com.example.trey.attempt2;

import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
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
            URL url = new URL("https://app.ticketmaster.com/discovery/v1/events.json?postalCode=90007&apikey=pGNwjKe1ggesYToqvem4wg7DgvyuInuV");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            String result;
            try {

                InputStream instream = (InputStream) url.getContent();
                result = convertStreamToString(instream);
                return result;
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return "messed up";
        }
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String temp = line + "\n";
                sb.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    protected void onPostExecute(String response) {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }

        Log.i("INFO", response);

    }
}


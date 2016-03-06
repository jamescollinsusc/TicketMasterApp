package com.example.trey.attempt2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class pageTwo extends AppCompatActivity {

    String[] cities={"LA","Miami","New York"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);
    }
}

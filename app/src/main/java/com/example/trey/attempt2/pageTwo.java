package com.example.trey.attempt2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class pageTwo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


     String[] cities={"City", "LA","Miami","New York"};
     Spinner chooseCity;
     EditText testText;
    ImageButton buttonOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

    chooseCity = (Spinner) findViewById(R.id.citySpinner);
    chooseCity.setOnItemSelectedListener(this);

    buttonOne= (ImageButton) findViewById(R.id.picture);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage();
            }
        });

    ArrayAdapter cityList = new ArrayAdapter(this, android.R.layout.simple_spinner_item,cities);
    cityList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    chooseCity.setAdapter(cityList);
    }

    private void nextPage() {
        Intent i = new Intent(this, pageThree.class);
        startActivity(i);
    }

    //after this is not real code -- ignore

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), cities[position], Toast.LENGTH_LONG).show();
       String chosenCity = chooseCity.getSelectedItem().toString();
        //testText.setText(chosenCity);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub
    }




}

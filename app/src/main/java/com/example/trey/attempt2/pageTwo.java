package com.example.trey.attempt2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class pageTwo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private String[] cities={"City", "LA","Miami","New York"};
    private Spinner chooseCity = (Spinner) findViewById(R.id.citySpinner);
    private EditText testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);



    chooseCity.setOnItemSelectedListener(this);

    ArrayAdapter cityList = new ArrayAdapter(this, android.R.layout.simple_spinner_item,cities);
    cityList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    chooseCity.setAdapter(cityList);
    }

    //after this is not real code -- ignore

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), cities[position], Toast.LENGTH_LONG).show();
        String chosenCity = chooseCity.getSelectedItem().toString();
        testText.setText(chosenCity);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub
    }



    public void useSpinner(String chosenCity) {

    }
}

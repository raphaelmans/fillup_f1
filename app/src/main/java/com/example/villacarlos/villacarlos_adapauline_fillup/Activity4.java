package com.example.villacarlos.villacarlos_adapauline_fillup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity4 extends AppCompatActivity {
EditText etAddress, etGender, etBirthPlace, etCitizen, etReligion;
Button exit, back3;
View.OnClickListener ocl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.button6){
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }

                if(v.getId() == R.id.button7){
                    Intent i = getIntent();
                    Bundle bForm = i.getExtras();
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("result",bForm);
                    setResult(RESULT_OK,resultIntent);
                    finish();
                }
            }
        };

        //Action Bar Title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Form");

        //Edit Text
        etAddress = (EditText)findViewById(R.id.editText18);
        etGender = (EditText)findViewById(R.id.editText19);
        etBirthPlace = (EditText)findViewById(R.id.editText20);
        etCitizen = (EditText)findViewById(R.id.editText21);
        etReligion = (EditText)findViewById(R.id.editText22);

        //Button
        exit = findViewById(R.id.button6);
        back3 = findViewById(R.id.button7);

        exit.setOnClickListener(ocl);
        back3.setOnClickListener(ocl);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String address = b.getString("keyAddress").toString();
        String gender = b.getString("keyGender").toString();
        String birthPlace = b.getString("keyBirthPlace").toString();
        String citizen = b.getString("keyCitizen").toString();
        String religion = b.getString("keyReligion").toString();

        etAddress.setText(address);
        etGender.setText(gender);
        etBirthPlace.setText(birthPlace);
        etCitizen.setText(citizen);
        etReligion.setText(religion);
    }

}
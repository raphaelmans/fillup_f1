package com.example.villacarlos.villacarlos_adapauline_fillup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
EditText etGender,etBirthDate,etPlaceBirth,etCitizen,etReligion;
Button save,back;
View.OnClickListener ocl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        //Action Bar Title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Form");

        //Edit Text
        etGender = (EditText)findViewById(R.id.editText7);
        etBirthDate = (EditText)findViewById(R.id.editText8);
        etPlaceBirth = (EditText)findViewById(R.id.editText9);
        etCitizen = (EditText)findViewById(R.id.editText10);
        etReligion = (EditText)findViewById(R.id.editText11);


        try{
            Bundle bundle = getIntent().getExtras();
            etGender.setText(bundle.getString("keyGender"));
            etBirthDate.setText(bundle.getString("keyBirthDate"));
            etPlaceBirth.setText(bundle.getString("keyBirthPlace"));
            etCitizen.setText(bundle.getString("keyCitizen"));
            etReligion.setText(bundle.getString("keyReligion"));


        }catch(Exception e){
            System.out.println(e);
        }

        ocl = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String gender = etGender.getText().toString();
                String birthDate = etBirthDate.getText().toString();
                String birthPlace = etPlaceBirth.getText().toString();
                String citizen = etCitizen.getText().toString();
                String religion = etReligion.getText().toString();

                if(v.getId()==R.id.button2){
                    Intent i = getIntent();
                    Bundle b = i.getExtras();

                    Intent intent = new Intent(getApplicationContext(),Activity3.class);


                    b.putString("keyGender",gender);
                    b.putString("keyBirthDate",birthDate);
                    b.putString("keyBirthPlace",birthPlace);
                    b.putString("keyCitizen",citizen);
                    b.putString("keyReligion",religion);

                    intent.putExtras(b);
                    startActivityForResult(intent,1);
                    Toast.makeText(getApplicationContext(),"Information saved",Toast.LENGTH_LONG).show();
                }

                if(v.getId()==R.id.button3){
                    Bundle bForm = new Bundle();
                    bForm.putString("keyGender",gender);
                    bForm.putString("keyBirthDate",birthDate);
                    bForm.putString("keyBirthPlace",birthPlace);
                    bForm.putString("keyCitizen",citizen);
                    bForm.putString("keyReligion",religion);
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("result",bForm);
                    setResult(RESULT_OK,resultIntent);
                    finish();
                }
            }
        };

        //Button
        save = findViewById(R.id.button2);
        back = findViewById(R.id.button3);

        save.setOnClickListener(ocl);
        back.setOnClickListener(ocl);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode == RESULT_OK){
            Bundle result = data.getBundleExtra("result");
        }
    }

}
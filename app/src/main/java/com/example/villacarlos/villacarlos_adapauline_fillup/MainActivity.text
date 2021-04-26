package com.example.villacarlos.villacarlos_adapauline_fillup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText etFName,etLName, etAge, etEmail, etContact,etAddress;
View.OnClickListener ocl;
Button next;
public static final int MESSAGE_CODE = 0;
Bundle bundleFromNext = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity2.class);
                String fName = etFName.getText().toString();
                String lName = etLName.getText().toString();
                String age = etAge.getText().toString();
                String email = etEmail.getText().toString();
                String contact = etContact.getText().toString();
                String address = etAddress.getText().toString();


                //Bundle
                Bundle b = new Bundle();
                b.putString("keyFName",fName);
                b.putString("keyLName",lName);
                b.putString("keyAge",age);
                b.putString("keyEmail",email);
                b.putString("keyContact",contact);
                b.putString("keyAddress",address);
                b.putAll(bundleFromNext);
                i.putExtras(b);

                startActivityForResult(i,MESSAGE_CODE);
            }
        };


        //Action Bar Title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Form");

        //Edit Text
        etFName = (EditText)findViewById(R.id.editText1);
        etLName = (EditText)findViewById(R.id.editText2);
        etAge = (EditText)findViewById(R.id.editText3);
        etEmail = (EditText)findViewById(R.id.editText4);
        etContact = (EditText)findViewById(R.id.editText5);
        etAddress = (EditText)findViewById(R.id.editText6);

        //Button
        next = findViewById(R.id.button1);
        next.setOnClickListener(ocl);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MESSAGE_CODE ){
            if(resultCode == RESULT_OK){
                bundleFromNext = data.getBundleExtra("result");
            }
        }
    }
}
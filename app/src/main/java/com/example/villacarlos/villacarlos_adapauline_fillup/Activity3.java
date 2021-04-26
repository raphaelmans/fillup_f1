package com.example.villacarlos.villacarlos_adapauline_fillup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity {
EditText etFName, etLName, etBirthday, etAge, etEmail, etContact;
Button next2, back2;
View.OnClickListener ocl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.button4){
                    Intent i = getIntent();
                    Bundle bForm = i.getExtras();
                    Intent intent = new Intent(getApplicationContext(),Activity4.class);
                    intent.putExtras(bForm);
                    startActivityForResult(intent,1);
                }

                if(v.getId() == R.id.button5){
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
        etFName = (EditText)findViewById(R.id.editText12);
        etLName = (EditText)findViewById(R.id.editText13);
        etBirthday = (EditText)findViewById(R.id.editText14);
        etAge = (EditText)findViewById(R.id.editText15);
        etEmail = (EditText)findViewById(R.id.editText16);
        etContact = (EditText)findViewById(R.id.editText17);


        //Button
        next2 = findViewById(R.id.button4);
        back2 = findViewById(R.id.button5);

        next2.setOnClickListener(ocl);
        back2.setOnClickListener(ocl);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        String fname = b.getString("keyFName").toString();
        String lname = b.getString("keyLName").toString();
        String birthday = b.getString("keyBirthDate").toString();
        String age = b.getString("keyAge").toString();
        String email = b.getString("keyEmail").toString();
        String contact = b.getString("keyContact").toString();

        etFName.setText(fname);
        etLName.setText(lname);
        etBirthday.setText(birthday);
        etAge.setText(age);
        etEmail.setText(email);
        etContact.setText(contact);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode == RESULT_OK){
            Bundle result = data.getBundleExtra("result");
        }
    }
}
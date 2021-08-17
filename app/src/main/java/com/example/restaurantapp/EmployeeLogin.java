package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class EmployeeLogin extends AppCompatActivity implements AdapterView.OnItemSelectedListener,  View.OnClickListener{
    ImageView imageBottom;
    Button  btn_Login;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        imageBottom = (ImageView) findViewById(R.id.imageBottom);
        btn_Login= (Button) findViewById(R.id.btnLogin);
        spinner = findViewById(R.id.menuSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Title, R.layout.selected_items);

        imageBottom.setOnClickListener(this);
        btn_Login.setOnClickListener(this);

        adapter.setDropDownViewResource(R.layout.drop_down);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.imageBottom:
                Intent intentImgBottom = new Intent(EmployeeLogin.this,MainActivity.class);
                startActivity(intentImgBottom);

                break;

            case R.id.btnLogin:
                Intent intentLogin = new Intent(EmployeeLogin.this,AdminMenu.class);
                startActivity(intentLogin);

                break;
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
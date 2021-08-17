package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_employee, btn_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_employee = (Button) findViewById(R.id.btnEmployee);
        btn_user= (Button) findViewById(R.id.btnUser);

        btn_employee.setOnClickListener(this);
        btn_user.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.btnEmployee:
                 Intent intentEmployee = new Intent(MainActivity.this, EmployeeLogin.class);
                 startActivity(intentEmployee);

                 break;
             case R.id.btnUser:
                 Intent intentUser = new Intent(MainActivity.this, Login.class);
                 startActivity(intentUser);

                 break;
         }
    }
}
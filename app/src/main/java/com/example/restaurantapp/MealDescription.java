package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MealDescription extends AppCompatActivity implements View.OnClickListener{
    ImageView back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_description);

        back_btn = findViewById(R.id.btnBack);

        back_btn.setOnClickListener(this);

    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBack:
                Intent intentBack = new Intent(MealDescription.this, UserMenu.class);
                startActivity(intentBack);

                break;


        }

    }
}
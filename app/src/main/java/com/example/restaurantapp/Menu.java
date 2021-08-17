package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{
    Spinner spinner;
    CardView card_view;
    ArrayAdapter<CharSequence> adapter;
    TextView txt_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        spinner = findViewById(R.id.menuSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.places, R.layout.selected_items);
        card_view = findViewById(R.id.friedChicken);
        txt_logout = (TextView)  findViewById(R.id.textLogout);


        adapter.setDropDownViewResource(R.layout.drop_down);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        card_view.setOnClickListener(this);
        txt_logout.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
     }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.friedChicken:
                Intent intentCard = new Intent(Menu.this, MealDescription.class);
                startActivity(intentCard);

                break;
            case R.id.textLogout:
                Intent intent_logout = new Intent(Menu.this, MainActivity.class);
                startActivity(intent_logout);

                break;



        }

    }
}
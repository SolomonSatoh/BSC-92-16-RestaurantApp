package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.restaurantapp.Domain.MenuDomain;

public class ShowDetails extends AppCompatActivity {
    private TextView addToCardBtn;
    private TextView titleTxt, priceTxt,recipeTxt, numberOrderTxt;
    private ImageView minusBtn,plusBtn,foodPic, btnBack;
    private int numberOrder =1;
    private MenuDomain object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        initView();
        getBundle();
    }

    private void getBundle() {
        object = (MenuDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable",this.getPackageName());


        Glide.with(this)
                .load(drawableResourceId)
                .into(foodPic);

        titleTxt.setText(object.getTitle());
        priceTxt.setText("MK "+object.getPrice());
        recipeTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               numberOrder = numberOrder +1;
               numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(numberOrder>1){
                   numberOrder= numberOrder-1;
               }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentImgBottom = new Intent(ShowDetails.this,UserMenu.class);
                startActivity(intentImgBottom);


            }
        });
    }

    private void initView() {
        btnBack = findViewById(R.id.btnBack);
        addToCardBtn = findViewById(R.id.btnAddToCard);
        titleTxt = findViewById(R.id.titleTxt);
        priceTxt = findViewById(R.id.priceTxt);
        recipeTxt = findViewById(R.id.recipeTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        foodPic = findViewById(R.id.foodPic);
    }
}
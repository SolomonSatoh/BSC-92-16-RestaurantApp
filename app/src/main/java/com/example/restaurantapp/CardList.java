package com.example.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Adapter.CardListAdapter;
import com.example.restaurantapp.Helper.CardManager;
import com.example.restaurantapp.Interface.ChangeNumberItemsListener;

public class CardList extends AppCompatActivity implements  View.OnClickListener {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private CardManager managementCart;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt, confirmOrder;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        confirmOrder = (TextView)  findViewById(R.id.orderBtn);


        managementCart = new CardManager(this);
        confirmOrder.setOnClickListener(this);


        initView();
        initList();
        calculateCard();
    }




    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CardListAdapter(managementCart.getListCard(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCard().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCard() {
        double percentTax = 0.02;
        double delivery = 10;

        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100.0) / 100.0;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100.0) / 100.0;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100.0) / 100.0;

        totalFeeTxt.setText("MK" + itemTotal);
        taxTxt.setText("MK" + tax);
        deliveryTxt.setText("MK" + delivery);
        totalTxt.setText("MK" + total);
    }
    private void initView() {
        recyclerViewList = findViewById(R.id.recyclerview);
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView4);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.orderBtn:
                Toast.makeText(CardList.this, "Your order was successful! Check your Email.", Toast.LENGTH_SHORT).show();
                Intent intentOrder= new Intent(CardList.this,UserMenu.class);
                startActivity(intentOrder);

                break;


        }

    }
}
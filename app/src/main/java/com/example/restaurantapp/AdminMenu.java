package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminMenu extends AppCompatActivity implements View.OnClickListener{
    ImageView imageBottom;
    TextView txt_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);


        imageBottom = (ImageView) findViewById(R.id.imageBottom);
        txt_logout = (TextView)  findViewById(R.id.txtLogout);

        imageBottom.setOnClickListener(this);
        txt_logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.imageBottom:

            case R.id.txtLogout:
                Intent intentImgBottom = new Intent(AdminMenu.this,MainActivity.class);
                startActivity(intentImgBottom);

                break;


        }

    }
}
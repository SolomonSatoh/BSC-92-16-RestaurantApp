package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.restaurantapp.Helper.DBHelper;

public class Login extends AppCompatActivity implements View.OnClickListener{
    EditText username, password;
    Button btn_signUp, btn_Login;
    ImageView imageBottom;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_signUp = (Button) findViewById(R.id.btnSignUp);
        btn_Login= (Button) findViewById(R.id.btnLogin);
        imageBottom = (ImageView) findViewById(R.id.imageBottom);
        username = (EditText)  findViewById(R.id.userName1);
        password = (EditText) findViewById(R.id.password1);

        btn_signUp.setOnClickListener(this);
        btn_Login.setOnClickListener(this);
        imageBottom.setOnClickListener(this);
        username.setOnClickListener(this);
        password.setOnClickListener(this);
        DB = new DBHelper(this);

    }

    @Override
    public void onClick(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();


        switch (view.getId()){
            case R.id.btnSignUp:
                Intent intentSignUp = new Intent(Login.this, SignUp.class);
                startActivity(intentSignUp);

                break;

            case R.id.btnLogin:
                if(user.equals("")|| pass.equals(""))
                    Toast.makeText(Login.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkUserNamePass(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(Login.this, "Login successful...", Toast.LENGTH_SHORT).show();
                        Intent intentLogin = new Intent(getApplicationContext(), UserMenu.class);
                        startActivity(intentLogin);

                    }else {
                        Toast.makeText(Login.this, "Invalid Credentials...", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.imageBottom:
                Intent intentImgBottom = new Intent(Login.this,MainActivity.class);
                startActivity(intentImgBottom);

                break;

        }

    }
}
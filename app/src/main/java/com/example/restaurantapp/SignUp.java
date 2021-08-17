 package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    EditText username, email, password, repassword;
    Button btn_signUp, btn_Login;
    ImageView imageBottom;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText)  findViewById(R.id.userName);
        email = (EditText)  findViewById(R.id.email);
        password = (EditText)  findViewById(R.id.password);
        repassword = (EditText)  findViewById(R.id.confPass);
        btn_signUp = (Button) findViewById(R.id.btnSignUp);
        btn_Login= (Button) findViewById(R.id.btnLogin);
        imageBottom = (ImageView) findViewById(R.id.imageBottom);

        btn_signUp.setOnClickListener(this);
        btn_Login.setOnClickListener(this);
        imageBottom.setOnClickListener(this);
        username.setOnClickListener(this);
        email.setOnClickListener(this);
        password.setOnClickListener(this);
        repassword.setOnClickListener(this);
        DB = new DBHelper(this);

    }

    @Override
    public void onClick(View view) {
        String user = username.getText().toString();
        String email1 = email.getText().toString();
        String pass = password.getText().toString();
        String repass = repassword.getText().toString();

        switch (view.getId()){
            case R.id.btnLogin:
                Intent intentLogin = new Intent(SignUp.this,Login.class);
                startActivity(intentLogin);

                break;

            case R.id.imageBottom:
                Intent intentImgBottom = new Intent(SignUp.this,MainActivity.class);
                startActivity(intentImgBottom);

                break;

            case R.id.btnSignUp:
                if (user.equals("")|| email1.equals("")|| pass.equals("")||repass.equals(""))
                    Toast.makeText(SignUp.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser =DB.checkUserName(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, email1, pass);
                            if(insert==true){
                                Toast.makeText(SignUp.this, "Registered Successfully...", Toast.LENGTH_SHORT).show();
                                Intent intentSignup = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intentSignup);
                            }else{
                                Toast.makeText(SignUp.this, "Registration failed...", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignUp.this, "User and email already exist! Please login.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(SignUp.this, "Passwords not matching.", Toast.LENGTH_SHORT).show();
                    }
                }


                break;

        }

    }
}
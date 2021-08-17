package com.example.restaurantapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String database_name = "Restaurant.db";


    public DBHelper( Context context) {

        super(context, "Restaurant.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase RestaurantDB) {
        RestaurantDB.execSQL(" create Table customers(username TEXT primary key, email TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase RestaurantDB, int oldVersion, int newVersion) {
        RestaurantDB.execSQL("drop Table if exists customers");

    }

    public Boolean insertData(String username, String email, String password ){
        SQLiteDatabase RestaurantDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);

        long results = RestaurantDB.insert("customers", null, contentValues);
        if(results == -1) return false;
        else
            return true;
    }

    public Boolean checkUserName(String username){
        SQLiteDatabase RestaurantDB = this.getWritableDatabase();
        Cursor cursor = RestaurantDB.rawQuery("Select * from customers where username =? ", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkUserNamePass(String username, String password){
        SQLiteDatabase RestaurantDB = this.getWritableDatabase();
        Cursor cursor = RestaurantDB.rawQuery("Select * from customers where username =? and password =? ", new String[] {username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkUserNameEmail(String username, String email){
        SQLiteDatabase RestaurantDB = this.getWritableDatabase();
        Cursor cursor = RestaurantDB.rawQuery("Select * from customers where username =? and email =? ", new String[] {username, email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


    public Boolean checkUserNameEmailPassword(String username, String email, String password){
        SQLiteDatabase RestaurantDB = this.getWritableDatabase();
        Cursor cursor = RestaurantDB.rawQuery("Select * from customers where username =? and email =? and password =? ", new String[] {username, email, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}

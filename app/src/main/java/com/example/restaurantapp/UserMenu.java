package com.example.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Adapter.CategoryAdapter;
import com.example.restaurantapp.Adapter.PopularAdapter;
import com.example.restaurantapp.Domain.CategoryDomain;
import com.example.restaurantapp.Domain.MenuDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class UserMenu extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spinner;
    TextView txt_logout;
    ArrayAdapter<CharSequence> adapter;
    private RecyclerView.Adapter adapter2,adapterMenu;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

        txt_logout = (TextView)  findViewById(R.id.textLogout);
        spinner = findViewById(R.id.menuSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.places, R.layout.selected_items);

        adapter.setDropDownViewResource(R.layout.drop_down);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        txt_logout.setOnClickListener(this);
        
        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();


    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMenu.this, CardList.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserMenu.this, UserMenu.class));
            }
        });
    }


    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false );
        recyclerViewPopularList = findViewById(R.id.recyclePopular);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<MenuDomain> menuList = new ArrayList<>();
        menuList.add(new MenuDomain("Tomato Pizza", "pizza2", "Lorem ipsum dolor sit amet. Ad enim  ", 999.99));
        menuList.add(new MenuDomain("Cheese Burger", "burger1", "Lorem ipsum dolor sit amet. Ad enim ", 899.99));
        menuList.add(new MenuDomain("Full Chicken", "fullchi", "Lorem ipsum dolor sit amet. Ad enim ", 699.99));
        menuList.add(new MenuDomain("Nsima Chambo", "simachambo", "Lorem ipsum dolor sit amet. Ad enim ", 599.99));
        menuList.add(new MenuDomain("Chips Sauce", "chipssauce", "Lorem ipsum dolor sit amet. Ad enim ", 499.99));
        menuList.add(new MenuDomain("Rice Chicken", "ricechik", "Lorem ipsum dolor sit amet. Ad enim ", 699.99));


        adapterMenu = new PopularAdapter(menuList);
        recyclerViewPopularList.setAdapter(adapterMenu);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false );
        recyclerViewCategoryList = findViewById(R.id.recyclerViewCate);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "pizza"));
        categoryList.add(new CategoryDomain("Burger", "burger"));
        categoryList.add(new CategoryDomain("Rice", "rice"));
        categoryList.add(new CategoryDomain("Nsima", "sima"));
        categoryList.add(new CategoryDomain("Drinks", "drinks"));
        categoryList.add(new CategoryDomain("Chips", "chips"));

        adapter2 = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.textLogout:
                Intent intent = new Intent(UserMenu.this, MainActivity.class);
                startActivity(intent);

                break;

        }

    }
}
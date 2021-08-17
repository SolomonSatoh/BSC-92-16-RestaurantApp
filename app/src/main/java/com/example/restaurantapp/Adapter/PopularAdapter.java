package com.example.restaurantapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.restaurantapp.Domain.CategoryDomain;
import com.example.restaurantapp.Domain.MenuDomain;
import com.example.restaurantapp.MealDescription;
import com.example.restaurantapp.Menu;
import com.example.restaurantapp.R;
import com.example.restaurantapp.ShowDetails;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<MenuDomain> menuDomains;

    public PopularAdapter(ArrayList<MenuDomain> menuDomains) {
        this.menuDomains = menuDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(menuDomains.get(position).getTitle());
        holder.price.setText(String.valueOf(menuDomains.get(position).getPrice()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(menuDomains.get(position).getPic(),
                "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCard = new Intent(holder.itemView.getContext(), ShowDetails.class);
                intentCard.putExtra("object", menuDomains.get(position));
                holder.itemView.getContext().startActivity(intentCard);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,price;
        ImageView pic;
        TextView addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.btnAdd);
        }
    }
}

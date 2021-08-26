package com.example.restaurantapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.restaurantapp.Domain.MenuDomain;
import com.example.restaurantapp.Helper.CardManager;
import com.example.restaurantapp.Interface.ChangeNumberItemsListener;
import com.example.restaurantapp.R;

import java.util.ArrayList;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {
   private ArrayList<MenuDomain> menuDomains;
    private CardManager managementCart;
    private ChangeNumberItemsListener changeNumberItemsListener;


    public CardListAdapter(ArrayList<MenuDomain> menuDomains, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.menuDomains = menuDomains;
        managementCart = new CardManager(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_card, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(menuDomains.get(position).getTitle());
        holder.price.setText(String.valueOf(menuDomains.get(position).getPrice()));

        holder.totalEachItem.setText(String.valueOf(Math.round((menuDomains.get(position).getNumberInCard() * menuDomains.get(position).getPrice()) * 100.0) / 100.0));
        holder.num.setText(String.valueOf(menuDomains.get(position).getNumberInCard()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(menuDomains.get(position).getPic(),
                "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managementCart.plusNumberFood(menuDomains, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });

        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managementCart.MinusNumerFood(menuDomains, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,price;
        ImageView pic, plusItem, minusItem;
        TextView totalEachItem, num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title2Txt);
            price = itemView.findViewById(R.id.feeEachItem);
            pic = itemView.findViewById(R.id.picCard);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            num = itemView.findViewById(R.id.numberItemTxt);
            plusItem = itemView.findViewById(R.id.plusCardBtn);
            minusItem = itemView.findViewById(R.id.minusCardBtn);
        }
    }
}

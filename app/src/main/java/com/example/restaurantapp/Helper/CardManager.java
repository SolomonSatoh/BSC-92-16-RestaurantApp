package com.example.restaurantapp.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.restaurantapp.Domain.MenuDomain;
import com.example.restaurantapp. Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class CardManager {
    private Context context;
    private CardDB cardDB;

    public CardManager(Context context) {
        this.context = context;
        this.cardDB = new CardDB(context);
    }

    public void insertFood(MenuDomain item) {
        ArrayList<MenuDomain> listFood = getListCard();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if (listFood.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listFood.get(n).setNumberInCard(item.getNumberInCard());
        } else {
            listFood.add(item);
        }

        cardDB.putListObject("CardList", listFood);
        Toast.makeText(context, "Added To Your Card", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<MenuDomain> getListCard() {
        return cardDB.getListObject("CardList");
    }

    public void plusNumberFood(ArrayList<MenuDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listfood.get(position).setNumberInCard(listfood.get(position).getNumberInCard() + 1);
        cardDB.putListObject("CardList", listfood);
        changeNumberItemsListener.changed();
    }

    public void MinusNumerFood(ArrayList<MenuDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listfood.get(position).getNumberInCard() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumberInCard(listfood.get(position).getNumberInCard() - 1);
        }
        cardDB.putListObject("CardList", listfood);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<MenuDomain> listFood2 = getListCard();
        double fee = 0;
        for (int i = 0; i < listFood2.size(); i++) {
            fee = fee + (listFood2.get(i).getPrice() * listFood2.get(i).getNumberInCard());
        }
        return fee;
    }
}

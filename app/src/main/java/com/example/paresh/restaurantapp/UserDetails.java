package com.example.paresh.restaurantapp;

import android.widget.CheckBox;

/**
 * Created by root on 23/3/17.
 */

public class UserDetails {

    private String name;
    private String item_price;
    private boolean checkBox;

    public UserDetails(String name, String item_price, boolean checkBox){
        this.name = name;
        this.item_price = item_price;
        this.checkBox = checkBox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public boolean getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }
}

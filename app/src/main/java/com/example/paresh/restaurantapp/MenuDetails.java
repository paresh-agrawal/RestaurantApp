package com.example.paresh.restaurantapp;

/**
 * Created by paresh on 21/6/17.
 */

import java.io.Serializable;

public class MenuDetails implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String item_name;

    private String item_price;

    private boolean isSelected;

    public MenuDetails(String item_name, String item_price, boolean isSelected) {

        this.item_name = item_name;
        this.item_price = item_price;
        this.isSelected = isSelected;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}

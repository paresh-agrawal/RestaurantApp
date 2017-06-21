package com.example.paresh.restaurantapp;

/**
 * Created by paresh on 21/6/17.
 */

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MenuDataAdapter extends
        RecyclerView.Adapter<MenuDataAdapter.ViewHolder> {

    private List<MenuDetails> menuList;

    public MenuDataAdapter(List<MenuDetails> menuActivities) {
        this.menuList = menuActivities;

    }

    // Create new views
    @Override
    public MenuDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.menu_list_item, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        final int pos = position;

        viewHolder.item_name.setText(menuList.get(position).getItem_name());

        viewHolder.item_price.setText(menuList.get(position).getItem_price());

        viewHolder.chkSelected.setChecked(menuList.get(position).isSelected());

        viewHolder.chkSelected.setTag(menuList.get(position));


        viewHolder.chkSelected.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                MenuDetails contact = (MenuDetails) cb.getTag();

                contact.setSelected(cb.isChecked());
                menuList.get(pos).setSelected(cb.isChecked());

                /* on cb clicked
                Toast.makeText(
                        v.getContext(),
                        "Clicked on Checkbox: " + cb.getText() + " is "
                                + cb.isChecked(), Toast.LENGTH_LONG).show();
                */
            }
        });

    }

    // Return the size arraylist
    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView item_name;
        public TextView item_price;

        public CheckBox chkSelected;

        public MenuDetails singlestudent;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            item_name = (TextView) itemLayoutView.findViewById(R.id.item_name);

            item_price = (TextView) itemLayoutView.findViewById(R.id.item_price);
            chkSelected = (CheckBox) itemLayoutView
                    .findViewById(R.id.chkSelected);

        }

    }

    // method to access in activity after updating selection
    public List<MenuDetails> getMenuList() {
        return menuList;
    }

}

package com.example.paresh.restaurantapp;

import android.app.Activity;
import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 23/3/17.
 */

public class RecyclerAdapterSearch extends RecyclerView.Adapter<RecyclerAdapterSearch.ViewHolder> {

    private Activity activity;
    private ArrayList<UserDetails> userDetails;



    public RecyclerAdapterSearch(Activity activity, ArrayList<UserDetails> userDetails){
        this.activity =activity;
        this.userDetails = userDetails;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.menu_item.setText(userDetails.get(position).getName());
        holder.item_price.setText(userDetails.get(position).getItem_price());
        holder.checkBox.isChecked();

    }

    public void setFilter(ArrayList<UserDetails> details){
        userDetails = new ArrayList<>();
        userDetails.addAll(details);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (userDetails!=null ? userDetails.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView menu_item, item_price;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            menu_item = (TextView)itemView.findViewById(R.id.name);
            item_price = (TextView)itemView.findViewById(R.id.item_price);
            checkBox = (CheckBox)itemView.findViewById(R.id.checkbox);
        }
    }
}

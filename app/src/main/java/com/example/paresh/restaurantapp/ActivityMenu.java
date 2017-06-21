package com.example.paresh.restaurantapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityMenu extends AppCompatActivity {

    private TextView mTextMessage;
    private RecyclerView recyclerView;
    private RecyclerAdapterSearch adapterSearch;
    private Button button;

    ArrayList<UserDetails> userList;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_food_menu:
                    return true;
                case R.id.navigation_specials:
                    return true;
                case R.id.navigation_dessert_and_beverages:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        userList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(ActivityMenu.this);
        recyclerView.setLayoutManager(layoutManager);
        adapterSearch = new RecyclerAdapterSearch(ActivityMenu.this,userList);
        recyclerView.setAdapter(adapterSearch);

        userList.add(new UserDetails("A","₹ 34",false));
        userList.add(new UserDetails("B","₹ 23",false));
        userList.add(new UserDetails("C","₹ 114",false));
        userList.add(new UserDetails("D","₹ 232",false));
        adapterSearch.notifyDataSetChanged();

        button = (Button)findViewById(R.id.button_filter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList<UserDetails> filteredList = filter(userList);
                adapterSearch.setFilter(filteredList);
                adapterSearch.notifyDataSetChanged();
            }
        });


    }
    ArrayList<UserDetails> filter(ArrayList<UserDetails> listUsers){
        int c = 0 ;
        final ArrayList<UserDetails> filtered = new ArrayList<>();

        for(UserDetails details : listUsers){
            Boolean checkbox = details.getCheckBox();

            if(checkbox == false){
                filtered.add(details);
            }
        }
        return filtered;
    }

}

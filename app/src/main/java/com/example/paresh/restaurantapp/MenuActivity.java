package com.example.paresh.restaurantapp;

/**
 * Created by paresh on 21/6/17.
 */

import java.util.ArrayList;
import java.util.List;
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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<MenuDetails> menuDetailsList;

    private Button btnSelection;

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
        setContentView(R.layout.activity_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        btnSelection = (Button) findViewById(R.id.btnShow);

        menuDetailsList = new ArrayList<MenuDetails>();

        for (int i = 1; i <= 15; i++) {
            MenuDetails st = new MenuDetails("MenuDetails " + i, "androidstudent" + i
                    + "@gmail.com", false);

            menuDetailsList.add(st);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // create an Object for Adapter
        mAdapter = new MenuDataAdapter(menuDetailsList);

        // set the adapter object to the Recyclerview
        mRecyclerView.setAdapter(mAdapter);

        btnSelection.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String data = "";
                List<MenuDetails> stList = ((MenuDataAdapter) mAdapter)
                        .getMenuList();

                for (int i = 0; i < stList.size(); i++) {
                    MenuDetails singleMenuDetails = stList.get(i);
                    if (singleMenuDetails.isSelected() == true) {

                        data = data + "\n" + singleMenuDetails.getItem_name().toString();
      /*
       * Toast.makeText( MenuActivity.this, " " +
       * singleMenuDetails.getName() + " " +
       * singleMenuDetails.getItem_price() + " " +
       * singleMenuDetails.isSelected(),
       * Toast.LENGTH_SHORT).show();
       */
                    }

                }

                Toast.makeText(MenuActivity.this,
                        "Selected Students: \n" + data, Toast.LENGTH_LONG)
                        .show();
            }
        });

    }

}

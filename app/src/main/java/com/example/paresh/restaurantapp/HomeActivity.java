package com.example.paresh.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Timer timer,colorTimer;
    int page = 0;
    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private LinearLayout home_book_a_table,home_menu,home_gallery,home_find_us,home_contact_us,home_offers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        home_book_a_table = (LinearLayout)findViewById(R.id.home_book_a_table);
        home_menu = (LinearLayout)findViewById(R.id.home_menu);
        home_gallery = (LinearLayout)findViewById(R.id.home_gallery);
        home_find_us = (LinearLayout)findViewById(R.id.home_find_us);
        home_contact_us = (LinearLayout)findViewById(R.id.home_contact_us);
        home_offers = (LinearLayout)findViewById(R.id.home_offers);

        //onTouch();
        TextView book = (TextView)findViewById(R.id.book_a_table);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                String name = sharedPreferences.getString("menu_item","not got");
                TextView name1 = (TextView)findViewById(R.id.menu);
                name1.setText(name);
            }
        });

        mCustomPagerAdapter = new CustomPagerAdapter(this);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(mViewPager, true);
        mViewPager.setAdapter(mCustomPagerAdapter);

        home_find_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findUs();
            }
        });
        home_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactUs();
            }
        });
        home_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryView();
            }
        });
        home_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuActivity();
            }
        });
        pageSwitcher();
    }

    public void findUs() {
        colorTimer = new Timer(); // At this line a new Thread will be created
        colorTimer.scheduleAtFixedRate(new find_us(), 0, 80); // delay
    }

    public void galleryView() {
        colorTimer = new Timer(); // At this line a new Thread will be created
        colorTimer.scheduleAtFixedRate(new gallery_view(), 0, 80); // delay
    }

    public void contactUs() {
        colorTimer = new Timer(); // At this line a new Thread will be created
        colorTimer.scheduleAtFixedRate(new contact_us(), 0, 80); // delay
    }

    public void menuActivity() {
        colorTimer = new Timer(); // At this line a new Thread will be created
        colorTimer.scheduleAtFixedRate(new menu_activity(), 0, 80); // delay
    }


    class find_us extends TimerTask {
        final int[] a = {0};
        @Override
        public void run() {
            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {
                    if (a[0] ==0){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            home_find_us.setBackground(getResources().getDrawable(R.color.colorPrimary));
                            a[0] =1;
                        }
                    }
                    else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            home_find_us.setBackgroundColor(Color.TRANSPARENT);
                            a[0] =0;
                            colorTimer.cancel();
                            final Intent exampleIntent = new Intent(HomeActivity.this, FindUs.class);
                            HomeActivity.this.startActivity(exampleIntent);
                        }
                    }

                }
            });

        }
    }

    class contact_us extends TimerTask {
        final int[] a = {0};
        @Override
        public void run() {
            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {
                    if (a[0] ==0){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            home_contact_us.setBackground(getResources().getDrawable(R.color.colorPrimary));
                            a[0] =1;
                        }
                    }
                    else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            home_contact_us.setBackgroundColor(Color.TRANSPARENT);
                            a[0] =0;
                            colorTimer.cancel();
                            final Intent exampleIntent = new Intent(HomeActivity.this, ContactUs.class);
                            HomeActivity.this.startActivity(exampleIntent);
                        }
                    }

                }
            });

        }
    }

    class gallery_view extends TimerTask {
        final int[] a = {0};
        @Override
        public void run() {
            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {
                    if (a[0] ==0){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            home_gallery.setBackground(getResources().getDrawable(R.color.colorPrimary));
                            a[0] =1;
                        }
                    }
                    else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            home_gallery.setBackgroundColor(Color.TRANSPARENT);
                            a[0] =0;
                            colorTimer.cancel();
                            final Intent exampleIntent = new Intent(HomeActivity.this, GalleryView.class);
                            HomeActivity.this.startActivity(exampleIntent);
                        }
                    }

                }
            });

        }
    }

    class menu_activity extends TimerTask {
        final int[] a = {0};
        @Override
        public void run() {
            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {
                    if (a[0] ==0){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            home_menu.setBackground(getResources().getDrawable(R.color.colorPrimary));
                            a[0] =1;
                        }
                    }
                    else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            home_menu.setBackgroundColor(Color.TRANSPARENT);
                            a[0] =0;
                            colorTimer.cancel();
                            final Intent exampleIntent = new Intent(HomeActivity.this, MenuActivity.class);
                            HomeActivity.this.startActivity(exampleIntent);
                        }
                    }

                }
            });

        }
    }

    public void pageSwitcher() {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, 3000); // delay
    }

    // this is an inner class...
    class RemindTask extends TimerTask {

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    if (page > 3) { // In my case the number of pages are 5
                        timer.cancel();
                        page = 0;
                        pageSwitcher();
                        // Showing a toast for just testing purpose
                    } else {
                        mViewPager.setCurrentItem(page++);
                    }
                }
            });

        }
    }

    private void onTouch() {
        home_book_a_table.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        home_book_a_table.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    default:
                        //set color back to default
                        home_book_a_table.setBackgroundColor(Color.TRANSPARENT);
                        break;
                }
                return true;
            }
        });
        home_menu.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        home_menu.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    default:
                        //set color back to default
                        home_menu.setBackgroundColor(Color.TRANSPARENT);
                        break;
                }
                return true;
            }
        });
        home_gallery.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        home_gallery.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    default:
                        //set color back to default
                        home_gallery.setBackgroundColor(Color.TRANSPARENT);
                        break;
                }
                return true;
            }
        });
        home_find_us.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        home_find_us.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    default:
                        //set color back to default
                        home_find_us.setBackgroundColor(Color.TRANSPARENT);
                        break;
                }
                return true;
            }
        });
        home_contact_us.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        home_contact_us.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    default:
                        //set color back to default
                        home_contact_us.setBackgroundColor(Color.TRANSPARENT);
                        break;
                }
                return true;
            }
        });
        home_offers.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        home_offers.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        break;
                    default:
                        //set color back to default
                        home_offers.setBackgroundColor(Color.TRANSPARENT);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_my_account) {
            final Intent registrationIntent = new Intent(HomeActivity.this, Registration.class);
            HomeActivity.this.startActivity(registrationIntent);
        } else if (id == R.id.nav_book_table) {
            final Intent exampleIntent = new Intent(HomeActivity.this, Example.class);
            HomeActivity.this.startActivity(exampleIntent);
        } else if (id == R.id.nav_menu) {
            final Intent findUsIntent = new Intent(HomeActivity.this, MenuActivity.class);
            HomeActivity.this.startActivity(findUsIntent);
        } else if (id == R.id.nav_find_us) {
            final Intent findUsIntent = new Intent(HomeActivity.this, FindUs.class);
            HomeActivity.this.startActivity(findUsIntent);
        } else if (id == R.id.nav_gallery) {
            final Intent findUsIntent = new Intent(HomeActivity.this, GalleryView.class);
            HomeActivity.this.startActivity(findUsIntent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_contact_us) {
            final Intent findUsIntent = new Intent(HomeActivity.this, ContactUs.class);
            HomeActivity.this.startActivity(findUsIntent);
        } else if (id == R.id.nav_offers) {

        } else if (id == R.id.nav_about_us) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

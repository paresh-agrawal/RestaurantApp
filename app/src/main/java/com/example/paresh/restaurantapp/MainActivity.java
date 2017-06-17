package com.example.paresh.restaurantapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent launchIntent = new Intent(MainActivity.this, HomeActivity.class);
                MainActivity.this.startActivity(launchIntent);
                MainActivity.this.finish();
            }
        }, 1000);
    }
}

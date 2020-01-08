package com.e.itineraryapp.splash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.e.itineraryapp.R;
import com.e.itineraryapp.itinerydetails.view.ItineryDetailsActivity;
import com.e.itineraryapp.utils.CommonUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                CommonUtils.reDirection(SplashActivity.this,ItineryDetailsActivity.class);
                finish();
            }
        },3000);

    }
}

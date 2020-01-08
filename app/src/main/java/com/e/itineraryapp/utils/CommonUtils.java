package com.e.itineraryapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.e.itineraryapp.R;
import com.e.itineraryapp.itinerydetails.view.ItineryDetailsActivity;
import com.e.itineraryapp.splash.view.SplashActivity;

public class CommonUtils {

    public static void reDirection(Context context, Class c){
        Intent intent = new Intent(context, c);
        context.startActivity(intent);
    }
}

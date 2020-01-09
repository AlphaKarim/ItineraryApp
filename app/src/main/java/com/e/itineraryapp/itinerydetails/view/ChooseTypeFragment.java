package com.e.itineraryapp.itinerydetails.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.e.itineraryapp.R;


public class ChooseTypeFragment extends Fragment {
    View view;
    ImageView plane,car,bike;
    FillDetailsFragment fillDetailsFragment;
    ChooseTypeFragment chooseTypeFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_choose_type, container, false);
        initializeViews();
        return view;
    }

    public void initializeViews(){
        ((ItineryDetailsActivity) getContext()).addDetails.setVisibility(View.GONE);
        fillDetailsFragment = new FillDetailsFragment();
        plane = view.findViewById(R.id.typePlane);
        car = view.findViewById(R.id.typeCar);
        bike = view.findViewById(R.id.typeBike);

        plane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ItineryDetailsActivity) getContext()).replaceFragment(fillDetailsFragment);
            }
        });
    }
}

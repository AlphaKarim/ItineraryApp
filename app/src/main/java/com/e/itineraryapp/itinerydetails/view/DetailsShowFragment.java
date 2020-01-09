package com.e.itineraryapp.itinerydetails.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.itineraryapp.R;


public class DetailsShowFragment extends Fragment {
    View view;
    RecyclerView itineraryRV;

    public DetailsShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_details_show, container, false);
        initializeViews();
        return view;
    }

    public void initializeViews(){

        ((ItineryDetailsActivity) getContext()).addDetails.setVisibility(View.VISIBLE);
        itineraryRV = view.findViewById(R.id.itineraryRV);
    }

}

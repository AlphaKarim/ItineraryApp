package com.e.itineraryapp.itinerydetails.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;

import com.e.itineraryapp.R;
import com.e.itineraryapp.itinerydetails.model.PlaneData;
import com.e.itineraryapp.itinerydetails.model.PlaneTicketDetailsModel;
import com.e.itineraryapp.itinerydetails.presenter.ItineraryDetailsListener;
import com.e.itineraryapp.itinerydetails.presenter.PlaneDataInterface;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;


public class DetailsShowFragment extends Fragment implements PlaneDataInterface {
    View view;
    RecyclerView itineraryRV;
    LinearLayout shimmer_layout;
    ShimmerFrameLayout shimmerFrameLayout;
    ItineraryDetailsAdapter itineraryDetailsAdapter;

    ItineraryDetailsListener itineraryDetailsListener;

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

    public void initializeViews() {
        ((ItineryDetailsActivity) getContext()).addDetails.setVisibility(View.VISIBLE);
        itineraryRV = view.findViewById(R.id.itineraryRV);
        shimmer_layout = view.findViewById(R.id.shimmer_layout);
        shimmerFrameLayout = view.findViewById(R.id.shimmer_view_container);
        shimmerFrameLayout.startShimmer();
        PlaneData planeData = new PlaneData(this);
        planeData.getPlaneTickets();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        itineraryDetailsListener = (ItineraryDetailsListener) context;
    }

    public void recyclerAnim() {
        if(getActivity() != null){
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.layout_animation_right_to_left);
            itineraryRV.setLayoutAnimation(controller);
            itineraryDetailsAdapter.notifyDataSetChanged();
            itineraryRV.scheduleLayoutAnimation();
        } else {
            return;
        }
    }

    @Override
    public void getTickets(ArrayList<PlaneTicketDetailsModel> planeTicketDetails) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        itineraryRV.setLayoutManager(linearLayoutManager);
        itineraryDetailsAdapter = new ItineraryDetailsAdapter(planeTicketDetails);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmerFrameLayout.stopShimmer();
                shimmer_layout.setVisibility(View.GONE);
                itineraryRV.setVisibility(View.VISIBLE);
                itineraryDetailsAdapter.notifyDataSetChanged();
                itineraryRV.setAdapter(itineraryDetailsAdapter);
                itineraryDetailsAdapter.notifyDataSetChanged();
                recyclerAnim();
            }
        },1000);
    }
}

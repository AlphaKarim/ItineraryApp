package com.e.itineraryapp.itinerydetails.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.e.itineraryapp.R;
import com.e.itineraryapp.itinerydetails.model.PlaneTicketDetailsModel;
import com.e.itineraryapp.itinerydetails.presenter.ItineraryDetailsListener;


public class FillDetailsFragment extends Fragment {
    View view;
    Button doneBtn;
    EditText numberEdx, fromTimeEdx, toTimeEdx, arrivalAtEdx, departureAtEdx, fromDateEdx, toDateEdx;
    String number,fromTime,toTime,arrivalAt, departureAt,journeyStartDate,journeyEndDate;
    DetailsShowFragment detailsShowFragment;
    ItineraryDetailsListener itineraryDetailsListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fill_details, container, false);
        initializeViews();
        return view;
    }

    public void initializeViews(){
        ((ItineryDetailsActivity) getContext()).addDetails.setVisibility(View.GONE);
        doneBtn = view.findViewById(R.id.doneBtn);
        numberEdx = view.findViewById(R.id.numberEdx);
        departureAtEdx = view.findViewById(R.id.departureEdx);
        arrivalAtEdx = view.findViewById(R.id.arrivalEdx);
        fromTimeEdx = view.findViewById(R.id.fromTomeEdx);
        toTimeEdx = view.findViewById(R.id.toTomeEdx);
        fromDateEdx = view.findViewById(R.id.fromDateEdx);
        toDateEdx = view.findViewById(R.id.toDateEdx);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                didTapButton(view);
                getTextData();
                //create model, object
                PlaneTicketDetailsModel planeTicketDetailsModel = new PlaneTicketDetailsModel(arrivalAt,departureAt,fromTime,toTime,number,journeyStartDate,journeyEndDate);
                detailsShowFragment = new DetailsShowFragment();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ((ItineryDetailsActivity) getContext()).replaceFragment(detailsShowFragment);
                    }
                },1000);

                itineraryDetailsListener.sendTicketDetails(planeTicketDetailsModel);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        itineraryDetailsListener = (ItineraryDetailsListener) context;
    }

    public void getTextData(){
        number = numberEdx.getText().toString();
        departureAt = departureAtEdx.getText().toString();
        arrivalAt = arrivalAtEdx.getText().toString();
        fromTime = fromTimeEdx.getText().toString();
        toTime = toTimeEdx.getText().toString();
        journeyStartDate = fromDateEdx.getText().toString();
        journeyEndDate = toDateEdx.getText().toString();
    }

    public void didTapButton(View view) {
        Button button = (Button)view.findViewById(R.id.doneBtn);
        final Animation myAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.blink);
        button.startAnimation(myAnim);
    }


}

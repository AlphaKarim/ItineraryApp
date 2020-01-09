package com.e.itineraryapp.itinerydetails.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.e.itineraryapp.R;
import com.e.itineraryapp.itinerydetails.model.PlaneData;
import com.e.itineraryapp.itinerydetails.model.PlaneTicketDetailsModel;
import com.e.itineraryapp.itinerydetails.presenter.ItineraryDetailsListener;

public class ItineryDetailsActivity extends AppCompatActivity implements ItineraryDetailsListener {

    public ImageView addDetails;
    FrameLayout frame_container;
    ChooseTypeFragment chooseTypeFragment;
    DetailsShowFragment detailsShowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinery_details);
        initializeViews();

    }
    public void initializeViews(){
        addDetails = findViewById(R.id.addButton);
        frame_container = findViewById(R.id.frame_container);
        detailsShowFragment = new DetailsShowFragment();
        replaceFragment(detailsShowFragment);

        addDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseTypeFragment = new ChooseTypeFragment();
                replaceFragment(chooseTypeFragment);
            }
        });
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commitAllowingStateLoss();
    }


    @Override
    public void sendTicketDetails(PlaneTicketDetailsModel planeTicketDetailsModel) {
        PlaneData planeData = new PlaneData();
        planeData.sendingPlaneTicketInfo(planeTicketDetailsModel);

    }

}

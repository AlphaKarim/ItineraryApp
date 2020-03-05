package com.e.itineraryapp.itinerydetails.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.e.itineraryapp.itinerydetails.presenter.PlaneDataInterface;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PlaneData {
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private ArrayList<PlaneTicketDetailsModel> planeTicketDetailsModelArrayList;
    private ArrayList<String> dataIds ;
    private  String detailsIdKeys;
    PlaneDataInterface planeDataInterface;

    public PlaneData(PlaneDataInterface planeDataInterface) {
        this.planeDataInterface = planeDataInterface;
    }
    public PlaneData(){

    }

    public void sendingPlaneTicketInfo(PlaneTicketDetailsModel planeTicketDetailsModel){

        mDatabase.child("uat").child("itinerary").push().setValue(planeTicketDetailsModel);
    }

    public ArrayList<PlaneTicketDetailsModel> getPlaneTicketInfo(){
        dataIds = new ArrayList<>();
        planeTicketDetailsModelArrayList = new ArrayList<>();
        try {
            mDatabase.child("uat").child("itinerary").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    planeTicketDetailsModelArrayList.clear();
                    for (DataSnapshot detailsFb :
                            dataSnapshot.getChildren()) {
                        PlaneTicketDetailsModel planeTicketDetailsModel = detailsFb.getValue(PlaneTicketDetailsModel.class);
                        planeTicketDetailsModelArrayList.add(planeTicketDetailsModel);
                        Log.e("planeTctModelArrayList",planeTicketDetailsModelArrayList.get(0).arraivalat);
                    }

                    /*for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        detailsIdKeys = ds.getKey();
                        dataIds.add(detailsIdKeys);
                    }
                    try {
                        for (int i = 0; i < dataIds.size(); i++) {
                            String currentDetailsID = dataIds.get(i);
                            mDatabase.child("uat").child("itinerary").child(currentDetailsID).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot detailsFb :
                                            dataSnapshot.getChildren()) {
                                        PlaneTicketDetailsModel planeTicketDetailsModel = detailsFb.getValue(PlaneTicketDetailsModel.class);
                                        planeTicketDetailsModelArrayList.add(planeTicketDetailsModel);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }*/





                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            }) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeTicketDetailsModelArrayList;
    }

    public void getPlaneTickets(){
        dataIds = new ArrayList<>();
        planeTicketDetailsModelArrayList = new ArrayList<>();
        try {
            mDatabase.child("uat").child("itinerary").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    planeTicketDetailsModelArrayList.clear();
                    for (DataSnapshot detailsFb :
                            dataSnapshot.getChildren()) {
                        PlaneTicketDetailsModel planeTicketDetailsModel = detailsFb.getValue(PlaneTicketDetailsModel.class);
                        planeTicketDetailsModelArrayList.add(planeTicketDetailsModel);
                        Log.e("planeTctModelArrayList",planeTicketDetailsModelArrayList.get(0).arraivalat);
                    }
                    planeDataInterface.getTickets(planeTicketDetailsModelArrayList);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            }) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

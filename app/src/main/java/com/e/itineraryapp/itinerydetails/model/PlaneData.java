package com.e.itineraryapp.itinerydetails.model;

import androidx.annotation.NonNull;

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

    public void sendingPlaneTicketInfo(PlaneTicketDetailsModel planeTicketDetailsModel){

        mDatabase.child("uat").child("itinerary").child(mDatabase.push().getKey()).setValue(planeTicketDetailsModel);
    }

    public void getPlaneTicketInfo(){
        dataIds = new ArrayList<>();
        planeTicketDetailsModelArrayList = new ArrayList<>();
        try {
            mDatabase.child("uat").child("itinerary").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
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
                    }





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

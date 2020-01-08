package com.e.itineraryapp.itinerydetails.model;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PlaneData {
    private static DatabaseReference mDatabase;
    public static void sendingPlaneTicketInfo(PlaneTicketDetailsModel planeTicketDetailsModel){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("uat").child("itinerary").child(mDatabase.push().getKey()).setValue(planeTicketDetailsModel);
    }

    public static void getPlaneTicketInfo(){
        mDatabase.child("uat").child("itinerary").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }) ;
    }
}

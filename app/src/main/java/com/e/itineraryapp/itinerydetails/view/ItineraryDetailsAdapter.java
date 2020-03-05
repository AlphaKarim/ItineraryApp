package com.e.itineraryapp.itinerydetails.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.itineraryapp.R;
import com.e.itineraryapp.itinerydetails.model.PlaneTicketDetailsModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ItineraryDetailsAdapter extends RecyclerView.Adapter<ItineraryDetailsAdapter.ViewHolder> {
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    ArrayList<PlaneTicketDetailsModel> planeTicketDetailsModelArrayList;

    public ItineraryDetailsAdapter(ArrayList<PlaneTicketDetailsModel> planeTicketDetailsModelArrayList) {
        this.planeTicketDetailsModelArrayList = planeTicketDetailsModelArrayList;
    }

    @NonNull
    @Override
    public ItineraryDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.itinerary_data_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItineraryDetailsAdapter.ViewHolder holder, final int position) {
        holder.number.setText(planeTicketDetailsModelArrayList.get(position).getTicketnumber());
        holder.fromTime.setText(planeTicketDetailsModelArrayList.get(position).getFromtime());
        holder.toTime.setText(planeTicketDetailsModelArrayList.get(position).getTotime());
        holder.arrival.setText(planeTicketDetailsModelArrayList.get(position).getArraivalat());
        holder.departure.setText(planeTicketDetailsModelArrayList.get(position).getDepartureat());
        holder.fromDate.setText(planeTicketDetailsModelArrayList.get(position).getFromdate());
        holder.toDate.setText(planeTicketDetailsModelArrayList.get(position).getTodate());
        holder.delete_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        Log.e("getItemCount",""+planeTicketDetailsModelArrayList.size());
        return planeTicketDetailsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView number,fromTime,toTime,arrival,departure,fromDate,toDate;
        FrameLayout delete_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);
            fromTime = itemView.findViewById(R.id.fromTimeTxt);
            toTime = itemView.findViewById(R.id.toTomeTxt);
            arrival = itemView.findViewById(R.id.arrivalTxt);
            departure = itemView.findViewById(R.id.departureTxt);
            fromDate = itemView.findViewById(R.id.fromDateTxt);
            toDate = itemView.findViewById(R.id.toDateTxt);
            delete_layout = itemView.findViewById(R.id.delete_layout);
        }
    }
}

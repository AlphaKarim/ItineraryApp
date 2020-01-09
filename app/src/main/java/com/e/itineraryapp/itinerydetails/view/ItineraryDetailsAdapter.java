package com.e.itineraryapp.itinerydetails.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.itineraryapp.R;
import com.e.itineraryapp.itinerydetails.model.PlaneTicketDetailsModel;

import java.util.ArrayList;

public class ItineraryDetailsAdapter extends RecyclerView.Adapter<ItineraryDetailsAdapter.ViewHolder> {

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
    public void onBindViewHolder(@NonNull ItineraryDetailsAdapter.ViewHolder holder, int position) {
        holder.number.setText(planeTicketDetailsModelArrayList.get(position).getTicketNumber());
        holder.fromTime.setText(planeTicketDetailsModelArrayList.get(position).getDepartureTime());
        holder.toTime.setText(planeTicketDetailsModelArrayList.get(position).getArraivalTime());
        holder.arrival.setText(planeTicketDetailsModelArrayList.get(position).getArraival());
        holder.departure.setText(planeTicketDetailsModelArrayList.get(position).getDestination());

    }

    @Override
    public int getItemCount() {
        return planeTicketDetailsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView number,fromTime,toTime,arrival,departure;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);
            fromTime = itemView.findViewById(R.id.fromTimeTxt);
            toTime = itemView.findViewById(R.id.toTomeTxt);
            arrival = itemView.findViewById(R.id.arrivalTxt);
            departure = itemView.findViewById(R.id.departureTxt);
        }
    }
}

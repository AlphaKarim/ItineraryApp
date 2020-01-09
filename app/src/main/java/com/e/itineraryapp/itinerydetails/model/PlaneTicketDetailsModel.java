package com.e.itineraryapp.itinerydetails.model;

import com.e.itineraryapp.itinerydetails.presenter.ItineraryDetailsListener;

public class PlaneTicketDetailsModel {
    String arraival;
    String destination;
    String arraivalTime;
    String departureTime;
    int ticketNumber;

    public PlaneTicketDetailsModel(String arraival, String destination, String arraivalTime, String departureTime, int ticketNumber) {
        this.arraival = arraival;
        this.destination = destination;
        this.arraivalTime = arraivalTime;
        this.departureTime = departureTime;
        this.ticketNumber = ticketNumber;
    }

    public String getArraival() {
        return arraival;
    }

    public void setArraival(String arraival) {
        this.arraival = arraival;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getArraivalTime() {
        return arraivalTime;
    }

    public void setArraivalTime(String arraivalTime) {
        this.arraivalTime = arraivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }


    class sendData implements ItineraryDetailsListener {



        @Override
        public void sendTicketDetails(PlaneTicketDetailsModel planeTicketDetailsModel) {

        }

        //API call
    }
}

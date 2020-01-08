package com.e.itineraryapp.itinerydetails.model;

public class PlaneTicketDetailsModel {
    String arraival;
    String destination;
    String arraivalTime;
    String destinationTime;
    int ticketNumber;

    public PlaneTicketDetailsModel(String arraival, String destination, String arraivalTime, String destinationTime, int ticketNumber) {
        this.arraival = arraival;
        this.destination = destination;
        this.arraivalTime = arraivalTime;
        this.destinationTime = destinationTime;
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

    public String getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}

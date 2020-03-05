package com.e.itineraryapp.itinerydetails.model;

import com.e.itineraryapp.itinerydetails.presenter.ItineraryDetailsListener;

public class PlaneTicketDetailsModel {
    String arraivalat;
    String departureat;
    String fromtime;
    String totime;
    String ticketnumber;
    String fromdate;
    String todate;

    public PlaneTicketDetailsModel(String arraivalat, String departureat, String fromtime, String totime, String ticketnumber, String fromdate, String todate) {
        this.arraivalat = arraivalat;
        this.departureat = departureat;
        this.fromtime = fromtime;
        this.totime = totime;
        this.ticketnumber = ticketnumber;
        this.fromdate = fromdate;
        this.todate = todate;
    }

    public PlaneTicketDetailsModel(){

    }

    public String getArraivalat() {
        return arraivalat;
    }

    public void setArraivalat(String arraivalat) {
        this.arraivalat = arraivalat;
    }

    public String getDepartureat() {
        return departureat;
    }

    public void setDepartureat(String departureat) {
        this.departureat = departureat;
    }

    public String getFromtime() {
        return fromtime;
    }

    public void setFromtime(String fromtime) {
        this.fromtime = fromtime;
    }

    public String getTotime() {
        return totime;
    }

    public void setTotime(String totime) {
        this.totime = totime;
    }

    public String getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(String ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }
}

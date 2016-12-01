package com.netcracker.petrusev.project2.beans.entities.flights;

import java.util.GregorianCalendar;

/**
 * Created by Asus on 13.10.2016.
 */
public class Flight {

    public static int objectsCounter = 0;
    private String from  = null;
    private String to = null;
    private GregorianCalendar date = null;
    private int id = 0;


    public Flight(String from, String to, GregorianCalendar date ) {
        this.from = from;
        this.to = to;
        this.date = date;
        objectsCounter++;
    }

    public Flight(){
        objectsCounter++;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj){

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Flight temper = (Flight) obj;
        return to.equals(temper.to) || from.equals(temper.from) || !date.equals(temper.date);
    }

    @Override
    public String toString(){
        return ("FLIGHT From " + from + " - TO - " + to + " - in - " + date.getTime() + "\n");
    }

    /**
     *
     * @return      the departure of the aircraft flight city
     * @see         String
     *
     **/
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setDate(GregorianCalendar date){
        this.date = date;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

}

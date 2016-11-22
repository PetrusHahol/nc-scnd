package com.netcracker.petrusev.project2.beans.entities.flights;

import java.io.Serializable;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * Created by Asus on 13.10.2016.
 */
public class Flight implements  Serializable,Comparable, Comparator<Flight> {


    private String from;
    private String to;
    private GregorianCalendar date;
    public static int objectsCounter = 0;

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
    public String toString(){
        return ("FLIGHT From " + from + " - TO - " + to + " - in - " + date.getTime() + "\n");
    }

    @Override
    public boolean equals(Object obj){

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Flight temper = (Flight) obj;
        return to.equals(temper.to) || from.equals(temper.from) || !date.equals(temper.date);
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

    @Override
    public int compareTo(Object obj) {
        Flight entry = (Flight) obj;
        int result =  entry.date.compareTo(this.date);
        if(result != 0) {
            return result;
        }
        return 0;
    }

    @Override
    public int compare(Flight obj1,Flight  obj2) {
        return obj1.from.compareTo(obj2.from);
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + date.hashCode();
        return result;
    }
}

package com.netcracker.petrusev.project2.beans.entities.office;

/**
 * Created by Asus on 14.10.2016.
 */
public class Pilot extends Employee {

    public static int objectsCounter;

    private int mileage = 0;
    private int id = 0;

    public Pilot(String name, int age, int height, int experience
            , String passportData, int mileage){
        super(name, age, height, experience, passportData);
        setMileage(mileage);
        objectsCounter++;
    }

    public Pilot(){
        objectsCounter++;
    }

    public Pilot(String name, int age, int height, int experience
            , String passportData){
        super(name, age, height, experience, passportData);
        objectsCounter++;
    }

    @Override
    public String toString(){
        return ("PILOT Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Experience - " + Integer.toString(experience)
                + " - Passport Data - " + passportData
                + " - Mileage - " + Integer.toString(mileage) + "\n");
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public int getMileage() {
        return this.mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

}

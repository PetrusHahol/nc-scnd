package com.netcracker.petrusev.project2.beans.entities.office;

/**
 * Created by Asus on 14.10.2016.
 */
public class Pilot extends Employee {
    private int mileage;
    public static int objectsCounter;

    private int id;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }


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



    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass())
            return false;
        Pilot temp =  (Pilot) obj;
        return (temp.name.equals(this.name) &&  temp.age == this.age
                && temp.height == this.height && temp.experience == this.experience
                && temp.passportData.equals(this.passportData) && temp.mileage == this.mileage);
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public int hashCode() {
        return getMileage();
    }
}

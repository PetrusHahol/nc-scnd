package com.netcracker.petrusev.project2.beans.entities.office;

/**
 * Created by Asus on 14.10.2016.
 */
public class Stewardess extends Employee {

    public static int objectsCounter;

    private int lengthWaist = 0;
    private int id = 0;

    public Stewardess(){}

    public Stewardess(String name, int age, int height, int experience
            , String passportData, int lengthWaist){
        super(name, age, height, experience, passportData);
        setLengthWaist(lengthWaist);
        objectsCounter++;
    }

    public Stewardess(String name, int age, int height, int experience
            , String passportData){
        super(name, age, height, experience, passportData);
        setLengthWaist(lengthWaist);
        objectsCounter++;
    }

    @Override
    public int hashCode() {
        return getLengthWaist();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return true;
        Stewardess temp =  (Stewardess) obj;
        return (temp.name.equals(this.name) &&  temp.age == this.age
                && temp.height == this.height && temp.experience == this.experience
                && temp.passportData.equals(this.passportData) && temp.lengthWaist == this.lengthWaist);
    }

    @Override
    public String toString(){
        return ("STEWARDESS Name " + name + " - Age - " + Integer.toString(age)
                +" - Height - " + Integer.toString(height)
                + " - Experience - " + Integer.toString(experience)
                + " - Passport Data - " + passportData
                + " - LengthWaist - " + lengthWaist + "\n");
    }



    public int getLengthWaist() {
        return this.lengthWaist;
    }
    public void setLengthWaist(int lengthWaist) {
        this.lengthWaist = lengthWaist;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
}

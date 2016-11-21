package com.netcracker.petrusev.project2.beans.entities.office;

/**
 * Created by Asus on 14.10.2016.
 */
public class Radioman extends Employee {

    private int countForeignLanguage;

    public static int objectsCounter;

    public Radioman(String name, int age, int height, int experience
                   , String passportData, int countForeignLanguage){

        super(name, age, height, experience, passportData);
        setCountForeignLanguage(countForeignLanguage);
        objectsCounter++;
    }

    public Radioman(String name, int age, int height, int experience
            , String passportData){
        super(name, age, height, experience, passportData);
        objectsCounter++;
    }
    public Radioman(){
        objectsCounter++;
    }

    @Override
    public String toString(){
        return ("RADIOMEN Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Experience - " + Integer.toString(experience)
                + " - Passport Data - " + passportData
                + " - Count Foreign Language - " + countForeignLanguage + "\n");
     }

     public int getCountForeignLanguage() {
        return this.countForeignLanguage;
    }

    @Override
    public int hashCode() {
        return getCountForeignLanguage();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Radioman temp =  (Radioman) obj;
        return (temp.name.equals(this.name) &&  temp.age == this.age
                && temp.height == this.height && temp.experience == this.experience
                && temp.passportData.equals(this.passportData) && temp.countForeignLanguage == this.countForeignLanguage);
    }

    public void setCountForeignLanguage(int countForeignLanguage) {
        this.countForeignLanguage = countForeignLanguage;
    }

}

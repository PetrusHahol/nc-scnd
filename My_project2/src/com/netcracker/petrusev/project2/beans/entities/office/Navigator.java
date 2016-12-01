package com.netcracker.petrusev.project2.beans.entities.office;

/**
 * Created by Asus on 14.10.2016.
 */
public class Navigator<T> extends Employee {

    public static int objectsCounter = 0;
    private T category;
    private int id = 0;

    public Navigator(String name, int age, int height, int experience
            , String passportData, T category){
        super(name, age, height, experience, passportData);
        setCategory(category);
        objectsCounter++;
    }
    public Navigator(){
    }

    public Navigator(String name, int age, int height, int experience
            , String passportData){
        super(name, age, height, experience, passportData);
        objectsCounter++;
    }
    @Override
    public int hashCode() {
        return getCategory().hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        Navigator temp =  (Navigator) obj;
        return (temp.name.equals(this.name) &&  temp.age == this.age
                && temp.height == this.height && temp.experience == this.experience
                && temp.passportData.equals(this.passportData) && temp.category.equals(this.category));
    }

    @Override
    public String toString(){
        return ("NAVIGATOR Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Experience - " + Integer.toString(experience)
                + " - Passport Data - " + passportData
                + " - Category - " + category + "\n");
    }


    public T getCategory() {
        return category;
    }
    public void setCategory(T category) {
        this.category = category;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

}

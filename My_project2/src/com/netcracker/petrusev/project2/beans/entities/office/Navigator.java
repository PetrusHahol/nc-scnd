package com.netcracker.petrusev.project2.beans.entities.office;

/**
 * Created by Asus on 14.10.2016.
 */
public class Navigator<T> extends Employee {

    private T category;
    public static int objectsCounter;

    public Navigator(String name, int age, int height, int experience
            , String passportData, T category){
        super(name, age, height, experience, passportData);
        setCategory(category);
        objectsCounter++;
    }

    @Override
    public String toString(){
        return ("NAVIGATOR Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Experience - " + Integer.toString(experience)
                + " - Passport Data - " + passportData
                + " - Category - " + category + "\n");
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

    public T getCategory() {
        return category;
    }

    public void setCategory(T category) {
        this.category = category;
    }

}

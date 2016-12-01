package com.netcracker.petrusev.project2.beans.entities.office;

/**
 * Created by Asus on 16.10.2016.
 */
public abstract class Employee {

    protected String name = null;
    protected int age;
    protected int height;
    protected int experience;
    protected String passportData = null;;

    public Employee(String name, int age, int height, int experience
            , String passportData){
        setName(name);
        setAge(age);
        setHeight(height);
        setExperience(experience);
        setPassportData(passportData);
    }

    public Employee(){
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public int getExperience() {
        return this.experience;
    }

    public String getPassportData() {
        return this.passportData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }


}

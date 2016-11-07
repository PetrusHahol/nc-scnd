package com.web.entities.office;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Asus on 16.10.2016.
 */
public abstract class Employee implements  Comparator<Pilot>{

    protected String name;
    protected int age;
    protected int height;
    protected int experience;
    protected String passportData;

    public Employee(String name, int age, int height, int experience
            , String passportData){
        setName(name);
        setAge(age);
        setHeight(height);
        setExperience(experience);
        setPassportData(passportData);
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

    @Override
    public int compare(Pilot obj1, Pilot obj2){
        if (obj1.experience > obj2.experience) return 1;
        if (obj1.experience < obj2.experience) return -1;
        else return 0;
    }
}

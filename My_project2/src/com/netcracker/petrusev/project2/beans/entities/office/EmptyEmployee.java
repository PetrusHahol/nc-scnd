package com.netcracker.petrusev.project2.beans.entities.office;

/**
 * Created by Asus on 20.11.2016.
 */
public class EmptyEmployee extends Employee {
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public int getExperience() {
        return super.getExperience();
    }

    @Override
    public String getPassportData() {
        return super.getPassportData();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    @Override
    public void setExperience(int experience) {
        super.setExperience(experience);
    }

    @Override
    public void setPassportData(String passportData) {
        super.setPassportData(passportData);
    }
}

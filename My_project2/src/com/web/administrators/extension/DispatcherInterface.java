package com.web.administrators.extension;

/**
 * Created by Asus on 17.10.2016.
 */
public interface DispatcherInterface<T> {

    void addNewRadioman(String name, int age, int height, int experience
            , String passportData, int countForeignLanguage);

    void addNewStewardess(String name, int age, int height, int experience
            , String passportData, int lengthWaist);

    void addNewNavigator(String name, int age, int height, int experience
            , String passportData, T category);

    void addNewPilot(String name, int age, int height, int experience
            , String passportData, int mileage);
}
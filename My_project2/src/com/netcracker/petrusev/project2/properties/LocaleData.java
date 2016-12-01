package com.netcracker.petrusev.project2.properties;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


/**
 * @author Petrusev
 * @version 1.0
 *
 */
public enum  LocaleData {
    INSTANCE;

    private static String PATH = "C:/Users/Asus/skaaa/pleease/My_project2/src/com/netcracker/petrusev/" +
                                 "project2/resources/locales/";//refactor!!!
    private static String PATH_TO_PROPERTIES = PATH+"message_eng.properties";
    private Properties prop = new Properties();

    public void setLocale(String locale){
        switch (locale) {
            case "ru":
                PATH_TO_PROPERTIES = PATH + "message_eng.properties";
                break;
            case "eng":
                PATH_TO_PROPERTIES = PATH + "message_ru.properties";
                break;
        }
    }

    public String getProperty(String nameProperty){
        String site = null;
        try {
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(PATH_TO_PROPERTIES), "cp1251"))) {
                prop.load(in);
                site = prop.getProperty(nameProperty);

            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error get message";
            //logs
        }
        return site;
    }
}

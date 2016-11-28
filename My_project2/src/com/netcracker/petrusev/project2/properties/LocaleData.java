package com.netcracker.petrusev.project2.properties;

import com.netcracker.petrusev.project2.constants.PageConstants;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by Asus on 28.11.2016.
 */
public enum  LocaleData {
    INSTANCE;

    private static String PATH = "C:/Users/Asus/skaaa/pleease/My_project2/src/com/netcracker/petrusev/" +
                                 "project2/resources/locales/";//refactor!!!
    private static String PATH_TO_PROPERTIES = PATH+"message_eng";
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
                            new FileInputStream(PATH_TO_PROPERTIES), StandardCharsets.UTF_8))) {
                prop.load(in);
                site = prop.getProperty(nameProperty);
                System.out.println(Locale.getDefault());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error get message";
            //logs
        }
        return site;
    }
}

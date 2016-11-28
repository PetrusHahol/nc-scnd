package com.netcracker.petrusev.project2.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

/**
 * Created by Asus on 19.11.2016.
 */
public enum UtilsGregorianCalendar {
    INSTANCE;
    public GregorianCalendar convertIntoGregorianCalendar(Timestamp time){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(time.getTime());
        return  gregorianCalendar;
    }
    public GregorianCalendar convertIntoGregorianCalendar(String time){
     GregorianCalendar gregorianCalendar = new GregorianCalendar();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = format.parse(time);
            gregorianCalendar.setTime(date);
        } catch (ParseException e) {
            return gregorianCalendar;
        }
        return gregorianCalendar;
    }

    public String convertFromGregorianCalendar(GregorianCalendar time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(time.getTime());
    }
}

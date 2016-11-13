package com.netcracker.petrusev.project2.beans.loader;

import com.netcracker.petrusev.project2.beans.administrators.Admin;

import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by Asus on 26.10.2016.
 */
public class FlightInit {

    private enum City{Minsk, Moskow, Voronezh, Gomel, Mogilev, Mars , Kiev, Pskow, Grodno, Wails}
    private Admin admin = new Admin();

    public FlightInit (){
        Random rand = new Random();
        City[] allCity = City.values();

        admin.addFlight(allCity[rand.nextInt(10) ].toString()
                , allCity[rand.nextInt(10) ].toString(), new GregorianCalendar(2016, 11, 18, 22, 23, 22));
        admin.addFlight(allCity[rand.nextInt(10)].toString()
                , allCity[rand.nextInt(10) ].toString(), new GregorianCalendar(2016, 10, 5, 6, 7));
        admin.addFlight(allCity[rand.nextInt(10) ].toString()
                , allCity[rand.nextInt(10)].toString(), new GregorianCalendar(2017, 5, 5, 6, 40));
        admin.addFlight(allCity[rand.nextInt(10) ].toString()
                , allCity[rand.nextInt(10)].toString(), new GregorianCalendar(2020, 9, 12, 20, 30, 50));
        admin.addFlight(allCity[rand.nextInt(10)].toString()
                , allCity[rand.nextInt(10) ].toString(), new GregorianCalendar(2020, 9, 12, 20, 30, 50));

    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightInit)) return false;

        FlightInit that = (FlightInit) o;
        return getAdmin() != null ? getAdmin().equals(that.getAdmin()) : that.getAdmin() == null;

    }

    @Override
    public int hashCode() {
        return getAdmin() != null ? getAdmin().hashCode() : 0;
    }
}




package com.netcracker.petrusev.project2.beans.administrators;

import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.connections.JDBC;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


public class Admin  {
    public JDBC jdbc = new JDBC();
    public static int objectsCounter;
    private Set<Flight> flights = new TreeSet<>();
    public Admin(){
        objectsCounter++;
    }

    public void downloadFlights(){
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("src/com/output/flights.txt"), StandardCharsets.UTF_8))){
            while (true) {
                in.readLine();
                addFlight(in.readLine(),in.readLine()
                                , new GregorianCalendar(Integer.parseInt(in.readLine())
                                , Integer.parseInt(in.readLine())
                                , Integer.parseInt(in.readLine())
                                , Integer.parseInt(in.readLine())
                                , Integer.parseInt(in.readLine())
                                , Integer.parseInt(in.readLine())));
            }
        } catch (IOException ex) {
           System.err.println("Wrong file");
        }
        catch(NumberFormatException ex){
            System.out.println("Download was done!");
        }
    }

    public  void addFlight(String from, String to, GregorianCalendar date)  {
            flights.add(new Flight(from, to, date));
            System.out.println("Add flight was done!");
    }

    public  void deleteFlight(int index) {
        int position = 0;
        for (Flight iter:flights) {
            position++;
            if (position == index) {
                flights.remove(iter);
                Dispatcher.brigadeToFlight.put(iter, null);
                break;
            }
        }
        System.out.println("Delete flight was done!");
    }


    public void saveFlights() {
        try (PrintWriter out = new PrintWriter(new File("src/com/output/flights.txt").getAbsoluteFile())) {
            try {
                for (Flight iter : flights) {
                    out.println("-----------");
                    out.print(iter.getFrom() + "\n" + iter.getTo()
                            + "\n" + iter.getDate().get(Calendar.YEAR) + "\n"
                            + iter.getDate().get(Calendar.MONTH) + "\n"
                            + iter.getDate().get(Calendar.DAY_OF_MONTH) + "\n"
                            + iter.getDate().get(Calendar.HOUR_OF_DAY) + "\n"
                            + iter.getDate().get(Calendar.MINUTE) + "\n"
                            + iter.getDate().get(Calendar.SECOND) + "\n");

                }
            } catch (NumberFormatException ex) {
                System.err.println("Error");
            }
        } catch (IOException ex) {
            System.err.println("Error");
        }
        finally {
            System.out.println("Save was done!");
        }
    }

    /**
     * Return flight facility on the position that
     * we passed in this method. If the position does not correspond
     * to any object, the result is null
     *
     * @param  index number of flights that your find in objects
     * @return the Flight object from index or null if Flight is missing
     * @see    Flight
     *
     *
     */
    public Flight indexIntoFlight(int index){
        int pos = 0;
        for (Flight iter : flights) {
            pos++;
            if (pos == index) {
                return iter;
            }
        }
        return null;
    }

    public PreparedStatement info(){
        try {
            return jdbc.getConnection().prepareStatement("SELECT * FROM flight");
        } catch (SQLException e) {
            return null;
        }
    }

    public void serialization(){
        try (FileOutputStream fos = new FileOutputStream("src/com/output/temp.out")){
            try( ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(flights);
            }
        }
        catch (IOException ex) {
            System.err.println("Not Serializable ");
        }
        finally {
            System.out.println("Serialization was done!");
        }
    }

    public void deserialization(){
        try (FileInputStream fos = new FileInputStream("src/com/output/temp.out")){
            try( ObjectInputStream oos = new ObjectInputStream(fos)) {
                try {
                    Set<Flight> tmp = (TreeSet<Flight>) oos.readObject();
                    flights.addAll(tmp);
                } catch (ClassNotFoundException e) {
                    System.err.println("Inappropriate object");
                }
            }
        }
        catch (IOException ex) {
            System.err.println("File is absent or corrupted");
        }
        finally {
            System.out.println("Deserialization was done!");
        }
    }


    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Admin temp = (Admin) obj;
        return temp.flights.equals(this.flights);
    }

    public Set<Flight> getFlights(){
        return flights;
    }

    @Override
    public int hashCode() {
        return flights.hashCode();
    }
}

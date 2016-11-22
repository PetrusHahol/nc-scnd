package com.netcracker.petrusev.project2.connections;

/**
 * Created by Asus on 22.11.2016.
 */
public enum DataMemory {
    INSTANCE;
    public void setId(int number){
        this.id = number;
    }
    public int getId(){
        return(this.id);
    }
    int id;
}

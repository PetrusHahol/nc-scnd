package com.netcracker.petrusev.project2.connections;


/**
 * @author Petrusev
 * @version 1.0
 *
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

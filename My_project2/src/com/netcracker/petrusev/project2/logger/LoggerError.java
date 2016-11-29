package com.netcracker.petrusev.project2.logger;


import org.apache.log4j.Logger;
/**
 * Created by Asus on 29.11.2016.
 */
public enum LoggerError {
    INSTANCE;
    private Logger logger;
    public void logError(Class sender, String message){
        logger = Logger.getLogger(sender);
        logger.error(message);
    }
}

package com.mephala.sanayiBackup.logging;

/**
 * Created by Mephalay on 11/12/2016.
 */
public class ApplicationLogger {
    private static ApplicationLogger instance;

    private ApplicationLogger() {

    }

    public static synchronized ApplicationLogger getInstance() {
        if (instance == null)
            instance = new ApplicationLogger();
        return instance;
    }
}

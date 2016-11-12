package com.mephala.sanayiBackup.props;

/**
 * Created by Mephalay on 11/12/2016.
 */
public class PropertyReader {

    private static PropertyReader instance;

    private PropertyReader(){
        try {

        } catch (Throwable t) {

        }
    }


    public static synchronized PropertyReader getInstance(){
        if(instance==null)
            instance = new PropertyReader();
        return instance;
    }

}

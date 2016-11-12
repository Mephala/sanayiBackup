package com.mephala.sanayiBackup.props;

import com.mephala.sanayiBackup.exception.SanayiBackupException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Mephalay on 11/12/2016.
 */
public class PropertyReader {

    private static PropertyReader instance;
    private static final String SANAYI_BACKUP_PROPS_FILE_NAME = "sanayiBackupProps.properties";
    private final Properties properties;

    private PropertyReader() throws SanayiBackupException {
        this.properties = new Properties();
        try {
            File sanayiPropsFile = new File(SANAYI_BACKUP_PROPS_FILE_NAME);
            if (sanayiPropsFile.exists()) {
                properties.load(FileUtils.openInputStream(sanayiPropsFile));
            } else {
                properties.load(this.getClass().getClassLoader().getResourceAsStream("defaultProps.properties"));
                URL defaultPropsFile = this.getClass().getClassLoader().getResource("defaultProps.properties");
                List<String> lines = IOUtils.readLines(defaultPropsFile.openStream());
                StringBuilder sb = new StringBuilder();
                for (String line : lines) {
                    sb.append(line + System.getProperty("line.separator"));
                }
                String defaultPropsFileData = sb.toString();
                if (!sanayiPropsFile.createNewFile()) {
                    throw new Exception("Can't write to local path.");
                }
                FileUtils.writeStringToFile(sanayiPropsFile, defaultPropsFileData);
            }
        } catch (Throwable t) {
            //TODO log exception.
            t.printStackTrace();
            throw new SanayiBackupException("Failed to construct property reader", t);
        }
    }

    public String getProperty(String key) {
        return (String) properties.get(key);
    }

    public List<String> getProperties(String key) {
        String val = (String) properties.get(key);
        List<String> retval = new ArrayList<String>();
        if (val.contains(",")) {
            String[] values = val.split(",");
            for (String value : values) {
                retval.add(value);
            }
        } else {
            retval.add(val);
        }
        return retval;
    }


    public static synchronized PropertyReader getInstance() throws SanayiBackupException {
        if (instance == null)
            instance = new PropertyReader();
        return instance;
    }

}

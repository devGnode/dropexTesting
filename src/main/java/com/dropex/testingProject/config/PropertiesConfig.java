package com.dropex.testingProject.config;

import com.dropex.testingProject.utils.ResourcesUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {

    private static final Logger LOGGER = Logger.getLogger(PropertiesConfig.class);
    private static final String PROPERTIES_FILE = "configuration.properties";

    private static PropertiesConfig INSTANCE = new PropertiesConfig();
    private Properties properties;

    public PropertiesConfig( ){
        try{
            (properties = new Properties())
            .load(
                ResourcesUtils.getPropertiesFile(PROPERTIES_FILE)
            );
        }catch (IOException e){
            LOGGER.error("Cannot load properties files");
            throw new RuntimeException(e.getMessage());
        }

    }

    public String get(String key){ return properties.getProperty(key); }

    public boolean getBool(String key){ return Boolean.valueOf(get(key)); }

    public static PropertiesConfig getInstance(){ return INSTANCE; }

}

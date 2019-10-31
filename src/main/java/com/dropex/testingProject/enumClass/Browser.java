package com.dropex.testingProject.enumClass;

import com.dropex.testingProject.utils.ResourcesUtils;
import org.apache.log4j.Logger;

import java.util.Properties;

public enum Browser {

    CHROME,
    OPERA,
    FIREFOX,
    MSEDGE,
    EXPLORER;

    public static final Logger LOGGER = Logger.getLogger(Browser.class);

    private static final String DEFAULT_BROWSER = "chrome";
    private String driverPath = null;

    public static Browser built(String browser){
            try {
                LOGGER.info("Set browser : "+browser);
                return Browser.valueOf(browser.toUpperCase());
            }catch (Exception e){
                LOGGER.info("Set browser by default : "+DEFAULT_BROWSER);
                Browser tmp = Browser.valueOf(DEFAULT_BROWSER);
                tmp.setPath("driver/chrome.exe");
                return tmp;
            }
    }

    public String getPath(){
        if(driverPath==null) init();
        return driverPath;
    }

    public Browser get( ){
        return this;
    }

    private void setPath(String path){
        driverPath = path;
    }

    private void init(){
        try{
            Properties prop = new Properties();
            prop.load(ResourcesUtils.getPropertiesFile("browser.properties"));
            prop.forEach((key, value)->{
                Browser.valueOf(key.toString().toUpperCase()).setPath(value.toString());
            });
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}

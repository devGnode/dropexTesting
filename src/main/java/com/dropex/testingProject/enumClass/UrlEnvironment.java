package com.dropex.testingProject.enumClass;

import com.dropex.testingProject.utils.ResourcesUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.logging.LogManager;

public enum  UrlEnvironment {

    ENVIRONMENT_01,
    ENVIRONMENT_02,
    CUSTOM;

    private final static Logger LOGGER          = Logger.getLogger(UrlEnvironment.class.getName());
    private final static String PROPERTIES_FILE = "url.properties";
    private String url = null;

    private static UrlEnvironment built(String url, boolean custom){
        if(custom){
            UrlEnvironment.CUSTOM.setUrl(url);
            return UrlEnvironment.CUSTOM;
        }
        return UrlEnvironment.valueOf(url.toUpperCase());
    }

    public static UrlEnvironment init(String env){
        return built(env,false);
    }

    public static UrlEnvironment initCustom(String env){
        return built(env,true);
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getUrl(String endPoint){
        if(url==null)loadEnv();
       return endPoint != null ?
               url +(url.endsWith("/")||endPoint.startsWith("/")?"":"/")+endPoint :
               url;
    }

    private void loadEnv(){
        BasicConfigurator.configure();
        try{
            System.out.println(ResourcesUtils.getContentFile(PROPERTIES_FILE));
            Properties env = new Properties();
            env.load(ResourcesUtils.getPropertiesFile(PROPERTIES_FILE));

            env.forEach((key,value)->{
                UrlEnvironment.valueOf(key.toString().toUpperCase()).setUrl(value.toString());
            });

        }catch (Exception e){
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}

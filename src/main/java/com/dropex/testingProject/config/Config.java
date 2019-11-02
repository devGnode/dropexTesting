package com.dropex.testingProject.config;


import com.dropex.testingProject.enumClass.Browser;
import com.dropex.testingProject.enumClass.UrlEnvironment;

public enum Config {

    INSTANCE;

    private PropertiesConfig prop = PropertiesConfig.getInstance();

    public UrlEnvironment url;
    public UrlEnvironment api;
    public Browser browser;

    public boolean enabledProxy;
    public boolean frontal;

    Config(){

        url             = UrlEnvironment.init(System.getProperty("environment",prop.get("default.environment")).toUpperCase());
        browser         = Browser.built(System.getProperty("browser",prop.get("default.browser")));
        enabledProxy    = Boolean.valueOf(System.getProperty("proxy",prop.get("proxy.enabled")));
        frontal         = Boolean.valueOf(System.getProperty("frontal","false"));
        api             = UrlEnvironment.init(System.getProperty("apiEnv","default_api").toUpperCase());

    }

    public UrlEnvironment setEnvironment(String environment){
        return (url=UrlEnvironment.init(environment));
    }

    public static Config getInstance(){ return INSTANCE; }
}

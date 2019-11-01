package com.dropex.testingProject.config;


import com.dropex.testingProject.enumClass.Browser;
import com.dropex.testingProject.enumClass.UrlEnvironment;

public enum Config {

    INSTANCE;

    private PropertiesConfig prop = PropertiesConfig.getInstance();

    public UrlEnvironment url;
    public Browser browser;

    public boolean enabledProxy;

    Config(){

        url             = UrlEnvironment.init(System.getProperty("environment",prop.get("default.environment")).toUpperCase());
        enabledProxy    = Boolean.valueOf(System.getProperty("proxy",prop.get("proxy.enabled")));
        browser         = Browser.built(System.getProperty("browser",prop.get("default.browser")));

    }

    public static Config getInstance(){ return INSTANCE; }
}

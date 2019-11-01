package com.dropex.testingProject.runner;

import com.dropex.testingProject.config.Config;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.BeforeClass;


public abstract class BaseRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void before_class(){
        BasicConfigurator.configure();
    }

    @BeforeClass
    public static void init_webdriver(){
        if(Config.getInstance().url == null )System.out.println("lfdsfdfd");
        else
        Config.getInstance().url.getUrl(null );

        System.out.println("-------------- Webdriver initialisation");
    }


}

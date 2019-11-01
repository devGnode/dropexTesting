package com.dropex.testingProject.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;

public abstract class BaseRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void before_class(){
        BasicConfigurator.configure();
    }
}

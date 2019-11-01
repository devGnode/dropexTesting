package com.dropex.testingProject.runner;

//import cucumber.api.junit.Cucumber;
//import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features",
        monochrome = false,
        glue = {"com.dropex.testingProject.step_definitions","com/dropex/testingProject/pageObjects"},
        //tags = "@frontal",
        plugin = {
            "pretty",
            "html:target/reports/html/htmlreport",
            "json:target/reports/jsonreports/index.json",
            "junit:target/reports/xmlreports.xml",
            "io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm",
        }
)
public class TestRunner extends BaseRunner{

}

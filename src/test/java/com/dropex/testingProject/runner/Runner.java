package com.dropex.testingProject.runner;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.Cucumber;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features",
        monochrome = false,
        glue = {"com.dropex.testingProject.stepsDef","com/dropex/testingProject/pageObjects"},
        tags = "@test",
        plugin = {
            "pretty",
            "html:target/reports/html/htmlreport",
            "json:targer/reports/jsonreports/index.json",
            "junit:target/reports/xmlreports.xml",
           // "io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm",
        }
)
public class BasicRunner extends BaseRunner{

}

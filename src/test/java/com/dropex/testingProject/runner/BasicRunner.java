package com.dropex.testingProject.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/features",
        monochrome = false,
        glue = {"com.dropex.testingProject.stepsDef","com/dropex/testingProject/pageObjects"},
        plugin = {
            "pretty",
            "html:target/reports/html/htmlreport",
            "json:targer/reports/jsonreports/index.json",
            "junit:target/reports/xmlreports.xml",
            "io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm",
        }
)
public class BasicRunner extends BaseRunner{

}

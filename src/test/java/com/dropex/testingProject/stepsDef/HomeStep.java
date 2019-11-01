package com.dropex.testingProject.stepsDef;

import com.dropex.testingProject.context.ScenarioContext;
import com.dropex.testingProject.pageObjects.HomePage;
import io.cucumber.java8.En;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.*;

public class HomeStep implements En {

    public HomeStep(
        ScenarioContext scenarioContext,
        HomePage homePage
    ){

        Given("^I navigate to home page$",()->{

            /*
            * Steps
            * */
            System.out.println("smlqdmqksdkmsqd");
            assertThat(homePage.test(),is(true));
        });

        And("^new Test$",()->{
            assertThat(true,is(true));
        });
    }
}


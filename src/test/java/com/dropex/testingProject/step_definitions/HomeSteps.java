package com.dropex.testingProject.step_definitions;

import com.dropex.testingProject.context.ScenarioContext;
import com.dropex.testingProject.pageObjects.HomePage;
import cucumber.api.java8.En;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class HomeSteps implements En {

    public HomeSteps(
        ScenarioContext scenarioContext,
        HomePage homePage
    ){

        Given("I navigate to home page",()->{

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


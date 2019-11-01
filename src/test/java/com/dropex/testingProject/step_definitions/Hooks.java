package com.dropex.testingProject.step_definitions;

import com.dropex.testingProject.context.ScenarioContext;
import com.dropex.testingProject.pageObjects.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public final class Hooks {

    private ScenarioContext scenarioContext;
    private HomePage homePage;

    public Hooks(
            ScenarioContext scenarioContext,
            HomePage homePage
    ){
        this.scenarioContext = scenarioContext;
        this.homePage = homePage;
    }

    @Before
    public void beforeInitWebdriver(){

        homePage.test();

    }

    @After
    public void afterClosewebdriver(){


    }
}

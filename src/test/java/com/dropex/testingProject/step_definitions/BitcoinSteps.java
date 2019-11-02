package com.dropex.testingProject.step_definitions;

import com.dropex.testingProject.context.ScenarioContext;
import com.dropex.testingProject.enumClass.Context;
import com.dropex.testingProject.pageObjects.BitcoinPage;
import com.dropex.testingProject.utils.JsonUtils;
import cucumber.api.java8.En;
import io.restassured.response.Response;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class BitcoinSteps implements En {

    public BitcoinSteps(
            ScenarioContext scenarioContext,
            BitcoinPage bitcoinPage
    ){

        Given("^I check balance bitcoin addr \"([^\"]*)\"$",(String addr)->{
            scenarioContext.set(
                    Context.LAST_REPONSE,
                    bitcoinPage.getResponceBitcoinAddrBalance(addr)
            );
        });

        And("^Balance value of this addr is equal to (\\d+\\.?\\d+F)$",(Float value)->{
            String response = ((Response)scenarioContext.get(Context.LAST_REPONSE))
                                .getBody()
                                .asString();

            JsonUtils lr = new JsonUtils(response);
            assertThat(lr.getFloat("balance"),is(equalTo(value)));
        });

        When("^I check last response status (\\d+)$",(Integer status)->{
            Response lastResponse = ((Response)scenarioContext.get(Context.LAST_REPONSE));

            assertThat(lastResponse.getStatusCode(),is(equalTo(status)));
        });

        Then("^I should be able to see a tx id \"([^\"]*)\"$",(String tx)->{
            String response = ((Response)scenarioContext.get(Context.LAST_REPONSE))
                    .getBody()
                    .asString();

            JsonUtils lr = new JsonUtils(response);
            String ret = (String )lr.getArray("transactions")
                .stream()
                .filter(elment->elment.equals(tx))
                .findFirst()
                .get();

            assertThat(ret,is(notNullValue()));
        });
    }
}

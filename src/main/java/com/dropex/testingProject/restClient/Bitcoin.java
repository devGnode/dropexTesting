package com.dropex.testingProject.restClient;


import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.apache.log4j.Logger;

public class Bitcoin extends AbstractRestClient{

    private static final Logger LOGGER = Logger.getLogger(Bitcoin.class);

    // init env
    private static final String URL                      = Bitcoin.setEnv("bitcoin");

    private static final String GET_BALANCE_ENDPOINT     = getUrl("api/addr/%s");

    public static Response getBalanceAddr(String addr){
        LOGGER.info("Bitcoin restAPI sending request to "+ getUrl() );
        LOGGER.info("Check balance addr = "+ addr );
        return given()
                .accept("application/json")
                .get(String.format(GET_BALANCE_ENDPOINT,addr));
    }

}

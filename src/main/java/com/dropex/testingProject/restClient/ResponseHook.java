package com.dropex.testingProject.restClient;

import com.dropex.testingProject.utils.JsonUtils;
import io.restassured.response.Response;

public class ResponseHook {

    private Response httpResponse;

    public ResponseHook(Response response){
        httpResponse = response;
    }

    public Response get(){
        return httpResponse;
    }

    public JsonUtils getJson(){
        return new JsonUtils(httpResponse.getBody().asString());
    }
}

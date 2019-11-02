package com.dropex.testingProject.restClient;

import com.dropex.testingProject.config.Config;
import com.dropex.testingProject.config.SystemProperties;

public class AbstractRestClient {

    protected static Config properties = SystemProperties.PROPERTIES_CONFIG;
    protected static String env;

    protected static String setEnv(String env){
        properties.setEnvironment(env);
       return (AbstractRestClient.env = properties.url.getUrl(null));
    }

    protected static  String getUrl(String endPoint){
        return env+(endPoint!=null?(env.endsWith("/")||endPoint.startsWith("/")?"":"/")+endPoint:"");
    }

    protected  static String getUrl( ){
        return getUrl(null);
    }

}

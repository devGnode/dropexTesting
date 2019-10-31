package com.dropex.testingProject.utils;

import org.apache.log4j.Logger;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourcesUtils {

    private final static Logger LOGGER = Logger.getLogger(ResourcesUtils.class);

    public static Path getresources(String path) throws URISyntaxException {
        return Paths.get(ResourcesUtils.class.getClassLoader().getResource(path).toURI());
    }

    public static String getContentFile(String path){
        String returned = null;

        try{
            returned = new String(Files.readAllBytes(getresources(path)));
        }catch(Exception e){
            LOGGER.error("Error to read file : ");
            throw new RuntimeException(e.getMessage());
        };
        return returned;
    }
}

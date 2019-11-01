package com.dropex.testingProject.utils;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static final int INFINITY_LOOP = 50000;

    public static Integer random(int min, int max){ return ThreadLocalRandom.current().nextInt(max)+min; }

    public static String randomString(int min, int max){ return random(min,max).toString(); }

    public static String genUUID(){ return UUID.randomUUID().toString(); }

    public static String generateId(int len){
        StringBuffer bf = new StringBuffer();

        while(bf.toString().length()<len)
            bf.append(
                    randomString(0,9)
            );

        return bf.toString();
    }

    public static int genUniqRandom(int min, int max, List<Integer> exclude){
        int returned = 0, infinityLoop = 0;

        if(exclude.size() > max )randomString(min,max);
        while(exclude.indexOf(returned=random(min,max))>-1);

        exclude.add(returned);
        return returned;
    }
}

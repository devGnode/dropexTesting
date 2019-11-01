package com.dropex.testingProject.context;

import com.dropex.testingProject.enumClass.Context;

import java.util.HashMap;

public class ScenarioContext {

    private static HashMap<String,Object> context;

    static {
        context = new HashMap<>();
    }

    public ScenarioContext(){}

    public boolean has(String key){
        try {
            context.get(key);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public <T> T get(Context key){
        return has(key.toString())?(T)context.get(key.toString()):null;
    }

    public void set(Context contextO, Object element){
        context.put(contextO.toString(),element);
    }

    public void clear(){
        context.clear();
    }

}

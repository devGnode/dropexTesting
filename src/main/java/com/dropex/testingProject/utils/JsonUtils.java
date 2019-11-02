package com.dropex.testingProject.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class JsonUtils {

    private JSONObject json;

    public JsonUtils(String template){
        this.json = new JSONObject(template);
    }

    public JsonUtils(JSONObject object){
        this.json = object;
    }

    public JsonUtils set(String key, Object value){
        this.json.put(key,value);
        return this;
    }

    public JsonUtils setString(String key, String value){
        this.json.put(key, value);
        return this;
    }

    public String getString(String key){
        return this.json.has(key) ? this.json.getString(key) : null;
    }

    public Integer getInteger(String key){
        return this.json.has(key) ? this.json.getInt(key) : null;
    }

    public List<JsonUtils> getListObject(String name){
        List<JsonUtils> list = new ArrayList<>();
        JSONArray  tmp  = this.json.getJSONArray(name);
        int i = 0, len = tmp.length();

        for(; i < len; i++)
            list.add(
                    new JsonUtils(tmp.getJSONObject(i))
            );

        return list;
    }

    public JsonUtils getObject(String name) {
        return new JsonUtils(
                this.json.getJSONObject( name )
        );
    }

    public Float getFloat(String key){
        return this.json.has(key) ? this.json.getFloat(key) : null;
    }

    public Double getDouble(String key){
        return this.json.has(key) ? this.json.getDouble(key) : null;
    }

    public JsonUtils setObject(String key, Map<String,Object> params){
        Iterator<Entry<String,Object>> iterator = params.entrySet().iterator();
        JSONObject object                       = new JSONObject();

        while( iterator.hasNext() ){
            Entry<String, Object> tmp = iterator.next();
            object.put(tmp.getKey(), tmp.getValue());
        }

        return set(key, object);
    }

    public JsonUtils setObjectInArray(String key, Map<String,Object> params){
        Iterator<Entry<String,Object>> iterator = params.entrySet().iterator();
        JSONObject object                       = new JSONObject();

        while( iterator.hasNext() ){
            Entry<String, Object> tmp = iterator.next();
            object.put(tmp.getKey(), tmp.getValue());
        }

        if(this.json.has(key))
            this.json.getJSONArray(key).put(object);
        else
           return set(
                   key, (new JSONArray()).put(object)
            );

        return this;
    }

    public List<?> getArray( String name ){
          return this.json.getJSONArray( name ).toList()
                .stream()
                .collect(Collectors.toList());
    }

    public String toString(){
        return this.json.toString();
    }
}

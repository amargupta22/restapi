package com.qa.util;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Amar on 13/06/18.
 */
public class TestUtil {

    public static String getValueByJPath(JSONObject responsejson, String jpath){
        Object obj = responsejson;
        for(String s : jpath.split("/"))
            if(!s.isEmpty())
                if(!(s.contains("[") || s.contains("]")))
                    obj = ((JSONObject) obj).get(s);
                else if(s.contains("[") || s.contains("]"))
                    obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
        return obj.toString();
    }

}


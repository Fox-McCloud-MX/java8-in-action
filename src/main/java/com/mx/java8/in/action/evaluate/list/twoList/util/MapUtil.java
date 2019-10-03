package com.mx.java8.in.action.evaluate.list.twoList.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MapUtil {

    public static String getValue(LinkedHashMap map, String key) {
        return (map.containsKey(key)) ? map.get(key).toString() : "";
    }
    
    public static LinkedHashMap getNode(LinkedHashMap map, String key) {
        return (map.containsKey(key)) ? (LinkedHashMap)map.get(key): new LinkedHashMap();
    }
    
    public static ArrayList<LinkedHashMap> getNodeArraylist(LinkedHashMap map, String key) {
        return (map.containsKey(key)) ? (ArrayList<LinkedHashMap>)map.get(key): new ArrayList<>();
    }
}

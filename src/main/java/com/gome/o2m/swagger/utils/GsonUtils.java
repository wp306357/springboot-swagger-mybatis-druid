package com.gome.o2m.swagger.utils;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/10/19.
 */
public class GsonUtils {
    private static Gson gson = new Gson();

    public static String beanToJson(Object o){
        return gson.toJson(o);
    }
}

package com.gome.o2m.swagger.service;

import com.gome.o2m.swagger.enums.CacheKeyEnums;
import com.gome.o2m.swagger.utils.GsonUtils;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/10/19.
 */
@Component
public class RedisService {
    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisTemplate redisTemplate;

    public void put(Object id, Object target, CacheKeyEnums keyEnums){
        ValueOperations opsForValue = this.redisTemplate.opsForValue();
        opsForValue.set(keyEnums.getKey()+String.valueOf(id), GsonUtils.beanToJson(target), keyEnums.getTimeout(), TimeUnit.SECONDS);
        logger.info("缓存数据:{},key:{}",GsonUtils.beanToJson(target), keyEnums.getKey()+id);
    }

    public Object get(Object id, CacheKeyEnums keyEnums){
        ValueOperations opsForValue = this.redisTemplate.opsForValue();
        Object o = opsForValue.get(keyEnums.getKey() + String.valueOf(id));
        return o;
    }
}

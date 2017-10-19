package com.gome.o2m.swagger.service.impl;

import com.gome.o2m.swagger.dao.SysRoleReadMapper;
import com.gome.o2m.swagger.enums.CacheKeyEnums;
import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.exception.ExceptionCodeEnum;
import com.gome.o2m.swagger.model.SysRole;
import com.gome.o2m.swagger.model.SysUser;
import com.gome.o2m.swagger.service.RedisService;
import com.gome.o2m.swagger.service.SysRoleReadService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class SysRoleReadServiceImpl implements SysRoleReadService {

    private static final Logger logger = LoggerFactory.getLogger(SysRoleReadServiceImpl.class);

    @Autowired
    private SysRoleReadMapper sysRoleReadMapper;
    @Autowired
    private RedisService redisService;


    @Override
    public List<SysRole> getRolesByUser(SysUser sysUser) throws CommonException {
        logger.info("SysRoleReadService.getRolesByUser() start, sysUser:", sysUser);
        if(null == sysUser || null == sysUser.getUid()){
            throw new CommonException(ExceptionCodeEnum.PARAM_ERROR);
        }
        List<SysRole> roles;
        Object o = redisService.get(sysUser.getUid(), CacheKeyEnums.USER_ROLE);
        if(null != o){
            roles = new Gson().fromJson(String.valueOf(o), new TypeToken<List<SysRole>>(){}.getType());
        }else {
            roles = sysRoleReadMapper.getRolesByUserId(sysUser.getUid());
            redisService.put(sysUser.getUid(), roles, CacheKeyEnums.USER_ROLE);
        }
        return roles;
    }

}

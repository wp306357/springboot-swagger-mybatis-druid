package com.gome.o2m.swagger.service.impl;

import com.gome.o2m.swagger.dao.SysPermissionReadMapper;
import com.gome.o2m.swagger.enums.CacheKeyEnums;
import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.exception.ExceptionCodeEnum;
import com.gome.o2m.swagger.model.SysPermission;
import com.gome.o2m.swagger.model.SysRole;
import com.gome.o2m.swagger.service.RedisService;
import com.gome.o2m.swagger.service.SysPermissionReadService;
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
public class SysPermissionReadServiceImpl implements SysPermissionReadService {
    private static final Logger logger = LoggerFactory.getLogger(SysPermissionReadServiceImpl.class);

    @Autowired
    private SysPermissionReadMapper sysPermissionReadMapper;
    @Autowired
    private RedisService redisService;

    @Override
    //@Cacheable(value="signonCache1", key="'role:permission:'+#sysRole.id", unless="#result==null")
    public List<SysPermission> getPermissionByRole(SysRole sysRole) throws CommonException {
        logger.info("SysPermissionReadService.getPermissionByRole() start, sysRole:", sysRole);
        if(null == sysRole || null == sysRole.getId()){
            throw new CommonException(ExceptionCodeEnum.PARAM_ERROR);
        }
        List<SysPermission> permissions;
        Object o = redisService.get(sysRole.getId(), CacheKeyEnums.ROLE_PERMISSION);
        if(null != o){
            permissions = new Gson().fromJson(String.valueOf(o), new TypeToken<List<SysPermission>>(){}.getType());
        }else {
            permissions = sysPermissionReadMapper.getPermissionByRoleId(sysRole.getId());
            redisService.put(sysRole.getId(), permissions, CacheKeyEnums.ROLE_PERMISSION);
        }
        return permissions;
    }
}

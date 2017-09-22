package com.gome.o2m.swagger.service.impl;

import com.gome.o2m.swagger.dao.SysUserReadMapper;
import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.exception.ExceptionCodeEnum;
import com.gome.o2m.swagger.model.SysUser;
import com.gome.o2m.swagger.service.SysUserReadService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class SysUserReadServiceImpl implements SysUserReadService {
    private static final Logger logger = LoggerFactory.getLogger(SysUserReadServiceImpl.class);

    @Autowired
    private SysUserReadMapper sysUserReadMapper;

    @Override
    public SysUser selectUser(String username) throws CommonException{
        if(StringUtils.isBlank(username)){
            throw new CommonException(ExceptionCodeEnum.PARAM_ERROR);
        }
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        return sysUserReadMapper.selectOne(sysUser);
    }
}

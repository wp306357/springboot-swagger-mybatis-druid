package com.gome.o2m.swagger.service.impl;

import com.gome.o2m.swagger.dao.SysRoleReadMapper;
import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.exception.ExceptionCodeEnum;
import com.gome.o2m.swagger.model.SysRole;
import com.gome.o2m.swagger.model.SysUser;
import com.gome.o2m.swagger.service.SysRoleReadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<SysRole> getRolesByUser(SysUser sysUser) throws CommonException {
        logger.info("SysRoleReadService.getRolesByUser() start, sysUser:", sysUser);
        if(null == sysUser || null == sysUser.getUid()){
            throw new CommonException(ExceptionCodeEnum.PARAM_ERROR);
        }
        return sysRoleReadMapper.getRolesByUserId(sysUser.getUid());
    }
}

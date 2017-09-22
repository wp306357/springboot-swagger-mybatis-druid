package com.gome.o2m.swagger.service.impl;

import com.gome.o2m.swagger.dao.SysPermissionReadMapper;
import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.exception.ExceptionCodeEnum;
import com.gome.o2m.swagger.model.SysPermission;
import com.gome.o2m.swagger.model.SysRole;
import com.gome.o2m.swagger.service.SysPermissionReadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<SysPermission> getPermissionByRole(SysRole sysRole) throws CommonException {
        logger.info("SysPermissionReadService.getPermissionByRole() start, sysRole:", sysRole);
        if(null == sysRole || null == sysRole.getId()){
            throw new CommonException(ExceptionCodeEnum.PARAM_ERROR);
        }
        return sysPermissionReadMapper.getPermissionByRoleId(sysRole.getId());
    }
}

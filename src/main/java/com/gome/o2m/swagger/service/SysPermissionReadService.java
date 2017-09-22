package com.gome.o2m.swagger.service;

import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.model.SysPermission;
import com.gome.o2m.swagger.model.SysRole;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface SysPermissionReadService {

    /**
     * 通过角色信息获取资源
     * @param sysRole 角色信息
     */
    List<SysPermission> getPermissionByRole(SysRole sysRole) throws CommonException;
}

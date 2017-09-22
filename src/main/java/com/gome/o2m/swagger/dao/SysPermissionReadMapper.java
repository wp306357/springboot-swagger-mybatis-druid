package com.gome.o2m.swagger.dao;

import com.gome.o2m.swagger.base.ReadMapper;
import com.gome.o2m.swagger.model.SysPermission;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface SysPermissionReadMapper extends ReadMapper<SysPermission> {

    List<SysPermission> getPermissionByRoleId(Long roleId);
}

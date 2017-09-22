package com.gome.o2m.swagger.service;

import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.model.SysRole;
import com.gome.o2m.swagger.model.SysUser;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface SysRoleReadService {
    /**
     * 通过用户信息获取角色信息
     * @param sysUser
     * @return
     */
    List<SysRole> getRolesByUser(SysUser sysUser) throws CommonException;
}

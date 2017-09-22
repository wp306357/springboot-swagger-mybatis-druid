package com.gome.o2m.swagger.dao;

import com.gome.o2m.swagger.base.ReadMapper;
import com.gome.o2m.swagger.model.SysRole;
import com.sun.tools.javac.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface SysRoleReadMapper extends ReadMapper<SysRole> {

    List<SysRole> getRolesByUserId(Long uid);
}

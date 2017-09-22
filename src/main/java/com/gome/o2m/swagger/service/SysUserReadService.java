package com.gome.o2m.swagger.service;

import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.model.SysUser;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface SysUserReadService {
    /**
     * 通过用户名查找用户
     * @param username 用户名
     */
    SysUser selectUser(String username) throws CommonException;
}

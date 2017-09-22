package com.gome.o2m.swagger.config.shiro;

import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.model.SysPermission;
import com.gome.o2m.swagger.model.SysRole;
import com.gome.o2m.swagger.model.SysUser;
import com.gome.o2m.swagger.service.SysPermissionReadService;
import com.gome.o2m.swagger.service.SysRoleReadService;
import com.gome.o2m.swagger.service.SysUserReadService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private SysUserReadService sysUserReadService;
    @Autowired
    private SysRoleReadService sysRoleReadService;
    @Autowired
    private SysPermissionReadService sysPermissionReadService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){
        logger.info("MyShiroRealm.doGetAuthorizationInfo()");
        SysUser sysUser = (SysUser)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        try {
            List<SysRole> roles = sysRoleReadService.getRolesByUser(sysUser);
            roles.stream().forEach(role -> {
                authorizationInfo.addRole(role.getRole());
                try {
                    List<SysPermission> sysPermissions = sysPermissionReadService.getPermissionByRole(role);
                    sysPermissions.stream().forEach(item -> authorizationInfo.addStringPermission(item.getPermission()));
                } catch (CommonException e) {
                    logger.error("获取资源错误:", e);
                }
            });
        } catch (CommonException e) {
            logger.error("获取角色错误:", e);
        }

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("MyShiroRealm.doGetAuthenticationInfo()");
        String username = (String)authenticationToken.getPrincipal();
        logger.info("用户:{} 登录,盐信息:{}",username, authenticationToken.getCredentials());
        SysUser sysUser;
        try {
            sysUser = sysUserReadService.selectUser(username);
            logger.info("获取到登录用户信息:{}", sysUser);
            if(null == sysUser){
                return null;
            }
        } catch (CommonException e) {
            logger.error("doGetAuthenticationInfo()异常:", e);
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser,
                sysUser.getPassword(),
                ByteSource.Util.bytes(sysUser.getCredentialsSalt()),
                getName()
        );
        return authenticationInfo;
    }
}

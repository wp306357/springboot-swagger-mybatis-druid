package com.gome.o2m.swagger.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/20.
 */
@Data
@Table(name = "sys_user")
@ToString
public class SysUser implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="Mysql")
    private Long uid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 名称（昵称或者真实姓名，不同系统不同定义）
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 加密密码的盐
     */
    private String salt;
    /**
     * 用户状态,
     * 0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 ,
     * 1:正常状态,
     * 2：用户被锁定.
     */
    private Short state;
    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
}

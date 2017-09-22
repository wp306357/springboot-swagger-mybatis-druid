package com.gome.o2m.swagger.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/9/20.
 */
@Data
@Table(name = "sys_role")
@ToString
public class SysRole{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="Mysql")
    private Long id;
    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一
     */
    private String role;
    /**
     * 角色描述,UI界面显示使用
     */
    private String description;
    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Boolean available = Boolean.TRUE;

}

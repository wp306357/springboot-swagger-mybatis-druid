package com.gome.o2m.swagger.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/9/20.
 */
@Data
@Table(name = "sys_permission")
@ToString
public class SysPermission {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="Mysql")
    private Integer id;
    /**
     * 名称.
     */
    private String name;
    /**
     * 资源类型，[menu|button]
     */
    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;
    /**
     * 资源路径.
     */
    private String url;
    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;
    /**
     * 父编号
     */
    private Long parentId;
    /**
     * 父编号列表
     */
    private String parentIds;
    /**
     * 是否可用
     */
    private Boolean available = Boolean.TRUE;
}

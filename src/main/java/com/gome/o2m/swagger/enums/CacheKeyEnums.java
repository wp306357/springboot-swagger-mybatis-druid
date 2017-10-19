package com.gome.o2m.swagger.enums;

import lombok.Getter;

/**
 * Created by Administrator on 2017/10/19.
 */
public enum CacheKeyEnums {
    USER_ROLE("user_role_", 5*60),
    ROLE_PERMISSION("role_permission_", 5*60);

    @Getter
    private String key;
    @Getter
    /**
     * 过期时间(单位:秒)
     */
    private Integer timeout;

    CacheKeyEnums(String key, Integer timeout){
        this.key = key;
        this.timeout = timeout;
    }
}

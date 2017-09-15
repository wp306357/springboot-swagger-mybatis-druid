package com.gome.o2m.swagger.exception;

import lombok.Getter;

/**
 * Created by Administrator on 2017/9/14.
 */
public enum  ExceptionTypeEnum {
    SYSTEM_ERROR("10"),
    BUSINESS_ERROR("20"),
    NOT_LOGIN_ERROR("30");

    @Getter
    private String code;

    ExceptionTypeEnum(String code){
        this.code = code;
    }
}

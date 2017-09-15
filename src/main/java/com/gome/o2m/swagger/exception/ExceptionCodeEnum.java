package com.gome.o2m.swagger.exception;

import lombok.Getter;

/**
 * Created by Administrator on 2017/9/13.
 */
public enum ExceptionCodeEnum {
    NOT_LOGIN_ERROR("not.login","用户未登录，请先登录!", ExceptionTypeEnum.NOT_LOGIN_ERROR),
    SYSTEM_ERROR("system.error","系统异常",ExceptionTypeEnum.SYSTEM_ERROR),
    PARAM_ERROR("param.error","参数异常",ExceptionTypeEnum.BUSINESS_ERROR);

    @Getter
    private String code;
    @Getter
    private String msg;
    @Getter
    private ExceptionTypeEnum typeEnum;

    ExceptionCodeEnum(String code, String msg, ExceptionTypeEnum typeEnum){
        this.code = code;
        this.msg = msg;
        this.typeEnum = typeEnum;
    }
}

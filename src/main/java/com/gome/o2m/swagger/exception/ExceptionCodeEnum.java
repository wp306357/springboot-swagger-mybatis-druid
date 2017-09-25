package com.gome.o2m.swagger.exception;

import lombok.Getter;

/**
 * Created by Administrator on 2017/9/13.
 */
public enum ExceptionCodeEnum {
    NOT_LOGIN_ERROR("not.login","用户未登录，请先登录!", ExceptionTypeEnum.NOT_LOGIN_ERROR),
    ACCOUNT_LOGIN_ERROR("account.login.error","账号或密码错误",ExceptionTypeEnum.BUSINESS_ERROR),
    VERIFY_CODE_ERROR("verify.code.error","验证码错误",ExceptionTypeEnum.BUSINESS_ERROR),
    UNAUTHORIZED_ROLE("unauthorized.role","权限验证失败,无权操作",ExceptionTypeEnum.NOT_LOGIN_ERROR),
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

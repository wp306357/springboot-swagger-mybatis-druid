package com.gome.o2m.swagger.exception;

import lombok.Getter;

/**
 * Created by Administrator on 2017/9/13.
 */
public class CommonException extends Exception {

    @Getter
    private ExceptionCodeEnum typeEnum;

    public CommonException(ExceptionCodeEnum typeEnum){
        super(typeEnum.getMsg());
        this.typeEnum = typeEnum;
    }
}

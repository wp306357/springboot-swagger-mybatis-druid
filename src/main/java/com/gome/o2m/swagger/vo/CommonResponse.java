package com.gome.o2m.swagger.vo;

import com.gome.o2m.swagger.base.BaseVo;
import com.gome.o2m.swagger.exception.ExceptionCodeEnum;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Administrator on 2017/9/13.
 */
@Data
@Builder
public class CommonResponse<T> extends BaseVo {
    /**
     * 成功标识
     */
    private Boolean isSuccess;
    /**
     * 响应码
     */
    private String errorCode;
    /**
     * 响应信息
     */
    private String errorMsg;
    /**
     * 响应结果
     */
    private T data;

    public static CommonResponse success(){
        return CommonResponse.builder()
                .isSuccess(true)
                .build();
    }

    public static CommonResponse success(Object data){
        return CommonResponse.builder()
                .isSuccess(true)
                .data(data)
                .build();
    }

    public static CommonResponse fail(String code, String msg){
        return CommonResponse.builder()
                .isSuccess(false)
                .errorCode(code)
                .errorMsg(msg)
                .build();
    }

    public static CommonResponse fail(ExceptionCodeEnum typeEnum){
        return CommonResponse.builder()
                .isSuccess(false)
                .errorCode(typeEnum.getCode())
                .errorMsg(typeEnum.getMsg())
                .build();
    }
}

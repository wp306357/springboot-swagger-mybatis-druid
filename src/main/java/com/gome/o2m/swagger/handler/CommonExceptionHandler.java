package com.gome.o2m.swagger.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/9/14.
 */
//@ControllerAdvice
public class CommonExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    /*@ExceptionHandler(value = {Exception.class, CommonException.class})
    @ResponseBody
    public CommonResponse commonExceptionHandler(HttpServletRequest request, Exception e){
        logger.error("请求:{}->发生异常:{}", request.getRequestURL(), e);
        if(e instanceof CommonException){
            CommonException exception = (CommonException)e;
            return CommonResponse.fail(exception.getTypeEnum());
        }
        return CommonResponse.fail(ExceptionCodeEnum.SYSTEM_ERROR);
    }*/
}

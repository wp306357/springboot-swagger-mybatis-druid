package com.gome.o2m.swagger.aop;

import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.exception.ExceptionCodeEnum;
import com.gome.o2m.swagger.vo.CommonResponse;
import org.apache.shiro.authz.UnauthorizedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * web层统一日志
 * @author wangpeng24
 * @date 2017/6/9 15:38
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Aspect
@Component
@Order(-10)//值越小越先执行
public class WebLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.gome.o2m.swagger.controller..*.*(..))")
    public void paramAspect(){}

    /**
     * 参数日志记录
     * 参考 http://blog.csdn.net/zmken497300/article/details/53516764
     * @param joinPoint
     * @return
     */
    @Around("paramAspect()")
    public Object intecptor(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String fullMethodName = className + "." + methodName;
        logger.info("请求方法:{}", fullMethodName);
        Object[] args = joinPoint.getArgs();
        logger.info("请求参数:{}", Stream.of(args).map(item -> item.toString()).collect(Collectors.joining(",")));
        long startTime = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("方法:{}->发生异常:{}", fullMethodName, throwable);
            if(throwable instanceof CommonException){
                CommonException exception = (CommonException)throwable;
                return CommonResponse.fail(exception.getTypeEnum());
            }
            if (throwable instanceof UnauthorizedException){
                return CommonResponse.fail(ExceptionCodeEnum.UNAUTHORIZED_ROLE);
            }
            return CommonResponse.fail(ExceptionCodeEnum.SYSTEM_ERROR);
        }finally {
            logger.info("执行时间:{}", (System.currentTimeMillis()-startTime));
        }
        return result;
    }
}

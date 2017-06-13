package com.gome.o2m.swagger.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.gome.o2m.swagger.controller..*.*(..))")
    public void webLog(){}

    @Pointcut("execution(public * com.gome.o2m.swagger.controller..*.*(..))")
    public void paramAspect(){}

    @Before("webLog()")
    public void before(){
        startTime.set(System.currentTimeMillis());
        logger.error("WebLogAspect.before::start");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String servletPath = request.getServletPath();

        logger.error("WebLogAspect.before::end-请求地址:{}", servletPath);
    }

    @AfterReturning(pointcut = "webLog()")
    public void after(){
        logger.error("WebLogAspect.after::执行时间:{}", (System.currentTimeMillis()-startTime.get()));
    }

    /**
     * 参数日志记录
     * 参考 http://blog.csdn.net/zmken497300/article/details/53516764
     * @param joinPoint
     * @return
     */
    @Around("paramAspect()")
    public Object intecptor(ProceedingJoinPoint joinPoint){
        Object result = null;
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        logger.error("WebLogAspect.intecptor::请求方法:{}", className + "." + methodName);
        Object[] args = joinPoint.getArgs();
        logger.error("请求参数:{}", Stream.of(args).map(item -> item.toString()).collect(Collectors.joining(",")));
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("WebLogAspect.intecptor.error:{}", throwable);
        }
        return result;
    }
}

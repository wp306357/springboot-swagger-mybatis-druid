package com.gome.o2m.swagger.controller;

import com.gome.o2m.swagger.exception.CommonException;
import com.gome.o2m.swagger.exception.ExceptionCodeEnum;
import com.gome.o2m.swagger.vo.CommonResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangpeng24
 * @date 2017/6/6 11:19
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    public String swaggerIndex(){
        //return "redirect:swagger-ui.html";
        return "redirect:index";
    }

    @RequestMapping("/index")
    @ResponseBody
    public CommonResponse<String> index(){
        Subject subject = SecurityUtils.getSubject();
        logger.info("login success,user:{}->token:{}",subject.getPrincipal(), subject.getSession().getId());
        return CommonResponse.success(subject.getSession().getId());
    }

    @RequestMapping("/login")
    @ResponseBody
    public CommonResponse login(HttpServletRequest request) throws CommonException {
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                logger.info("UnknownAccountException -- > 账号不存在：");
                throw new CommonException(ExceptionCodeEnum.AUUCOUNT_LOGIN_ERROR);
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                logger.info("IncorrectCredentialsException -- > 密码不正确：");
                throw new CommonException(ExceptionCodeEnum.AUUCOUNT_LOGIN_ERROR);
            } else if ("kaptchaValidateFailed".equals(exception)) {
                logger.info("kaptchaValidateFailed -- > 验证码错误");
                throw new CommonException(ExceptionCodeEnum.VERIFY_CODE_ERROR);
            } else {
                throw new CommonException(ExceptionCodeEnum.SYSTEM_ERROR);
            }
        }
        // 此方法不处理登录成功,由shiro进行处理
        return CommonResponse.fail(ExceptionCodeEnum.NOT_LOGIN_ERROR);
    }

    @RequestMapping("/403")
    @ResponseBody
    public CommonResponse unauthorizedRole(){
        return CommonResponse.fail(ExceptionCodeEnum.UNAUTHORIZED_ROLE);
    }
}

package com.gome.o2m.swagger.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author wangpeng24
 * @date 2017/6/7 18:03
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@SuppressWarnings("serial")
@WebServlet(
        urlPatterns="/druid/*",
        name = "druidStatViewServlet",
        initParams = {
            @WebInitParam(name = "allow", value = "127.0.0.1,10.122.1.8", description = "IP白名单(没有配置或者为空，则允许所有访问)"),
            @WebInitParam(name = "deny", value = "192.168.1.73", description = "IP黑名单 (存在共同时，deny优先于allow"),
            @WebInitParam(name = "loginUsername", value = "admin", description = "用户名"),
            @WebInitParam(name = "loginPassword", value = "123456", description = "密码"),
            @WebInitParam(name = "resetEnable", value = "false", description = "禁用HTML页面上的“Reset All”功能 ")
        }
)
public class DruidStatViewServlet extends StatViewServlet {
}

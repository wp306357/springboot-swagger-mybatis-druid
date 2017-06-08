package com.gome.o2m.swagger.config.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * druid 状态Filter
 * @author wangpeng24
 * @date 2017/6/7 18:00
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@WebFilter(
        filterName="druidWebStatFilter",
        urlPatterns = "/*",
        initParams = {@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*", description = "忽略资源")}
)
public class DruidStatFilter extends WebStatFilter {
}

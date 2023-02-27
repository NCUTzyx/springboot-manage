package com.zyx.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author 张宇森
 * @version 1.0
 */
//地区解析器 => 往Spring容器中注入
public class MvcLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求链接中的参数
        String lang = request.getParameter("lang");

        Locale locale = Locale.getDefault();  //默认的

        //参数不为空=>请求链接有国际化的参数
        if(!StringUtils.isEmpty(lang)){
            //zh_CN
            String[] s = lang.split("_");
            //国际=>语言/地区
            locale = new Locale(s[0], s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}

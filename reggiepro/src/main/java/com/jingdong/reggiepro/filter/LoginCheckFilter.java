package com.jingdong.reggiepro.filter;

import com.alibaba.fastjson.JSON;
import com.jingdong.reggiepro.common.R;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//过滤器:检查用户是否已经登录
//@WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//
//        //获取本次请求的URI
//        String str = httpServletRequest.getRequestURI();
//        //定义不需要处理的请求
//        String[] strList = new String[]{
//                "/employee/login",
//                "/employee/logout",
//                "/pages/**"
//        };
//        AntPathMatcher antPathMatcher = new AntPathMatcher();
//        for (String s : strList) {
//            if(antPathMatcher.match(s,str)){
//                filterChain.doFilter(httpServletRequest,httpServletResponse);
//                return;
//            }
//        }
//        //如果已经登录,直接放行
//        if(httpServletRequest.getSession().getAttribute("employee")!=null){
//            filterChain.doFilter(httpServletRequest,httpServletResponse);
//            return;
//        }
//
//        //如果未登录,返回未登录结果
//        System.out.println(777777777);
//        httpServletResponse.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }
}

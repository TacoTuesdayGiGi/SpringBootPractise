package com.co.cn.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.co.cn.reggie.common.BaseContext;
import com.co.cn.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    public static AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        log.info("拦截到请求:{}", url);
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"
        };

        boolean check = check(urls, url);
        if (check) {
            chain.doFilter(request, response);
            return;
        }

        if (request.getSession().getAttribute("employee") != null) {
            String empId = (String) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);
            chain.doFilter(request, response);
            return;
        }
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    private boolean check(String[] urls, String request) {
        for (String url : urls) {
            boolean match = antPathMatcher.match(url, request);
            if (match) {
                return true;
            }
        }
        return false;
    }

}

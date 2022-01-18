package com.qirui.crm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginInterceptor implements HandlerInterceptor {

    /*
        参数：handler Object : 被拦截的controller对象
        返回值：true : 放行
               false:截断

     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/index.html";
        StringBuffer url = request.getRequestURL();
        if(uri.contains("login")||uri.contains(".js")||uri.contains("IMG_7114.JPG")||uri.contains(".css")||basePath.contains(url)){
            return true;
        }
        boolean flag = true;
        Object user = request.getSession().getAttribute("user");
        if (user == null){
            flag = false;
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
        return flag;
    }
}

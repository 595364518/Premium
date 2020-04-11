package com.lhb.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: yaya
 * @create: 2020/4/11
 */
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("level");
        if(obj == null){
            request.setAttribute("msg","请先登录");
            System.out.println("admin拦截成功");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else if((Integer)obj != 255){
            request.setAttribute("msgAdmin","没有权限");
            System.out.println("admin拦截成功");
            request.getRequestDispatcher("/home").forward(request,response);
            return false;
        }
        request.setAttribute("msg","");
        request.setAttribute("msgAdmin","");
        return true;
    }
}

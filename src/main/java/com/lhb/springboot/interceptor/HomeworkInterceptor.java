package com.lhb.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: yaya
 * @create: 2020/4/11
 */
public class HomeworkInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("username");
        if(obj == null || obj == ""){
            request.setAttribute("msg1","请先登录");
            System.out.println("list拦截成功");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        request.setAttribute("msg1","");
        return true;
    }
}

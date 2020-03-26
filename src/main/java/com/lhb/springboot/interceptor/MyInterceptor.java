package com.lhb.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 05:17 2020/3/13
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object loginUser = request.getSession().getAttribute("userLogin");
        Object level = request.getSession().getAttribute("level");
        if (loginUser==null){
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        System.out.println("login未拦截");
        request.setAttribute("msg","");
        return true;
    }
}

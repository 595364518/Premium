package com.lhb.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:00 2020/3/18
 */
public class DownLoadInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("level");
        if((Long)obj == 1L){
            request.setAttribute("msg1","没有权限");
            System.out.println("download拦截成功");
            request.getRequestDispatcher("/note").forward(request,response);
            return false;
        }
        request.setAttribute("msg1","");
        return true;
    }
}

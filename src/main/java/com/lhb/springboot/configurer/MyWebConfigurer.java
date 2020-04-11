package com.lhb.springboot.configurer;

import com.lhb.springboot.interceptor.AdminInterceptor;
import com.lhb.springboot.interceptor.DownLoadInterceptor;
import com.lhb.springboot.interceptor.HomeworkInterceptor;
import com.lhb.springboot.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 05:26 2020/3/13
 */
@Configuration
public class MyWebConfigurer {
    @Bean
    public WebMvcConfigurer myWebMvcConfigurer(){
        return new WebMvcConfigurer() {
            //添加视图控制
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("user/login");
                registry.addViewController("/index").setViewName("homework/list");
                registry.addViewController("/upload").setViewName("homework/uploadFile");
                registry.addViewController("/note").setViewName("homework/notePage");
                registry.addViewController("/homes").setViewName("main/home");
            }

            //添加拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/login")
                .excludePathPatterns("/users/*")
                .excludePathPatterns("/users/homeworks/file","/users/homeworks/upload",
                        "/users/homeworks/getTimes","/users/homeworks/isMatch")
                .excludePathPatterns("/css/**","/img/**","/fonts/**","/js/**","/music/**","/webjars/**");
                registry.addInterceptor(new DownLoadInterceptor()).addPathPatterns("/users/homeworks/downloadFile");
                registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
            }
            //设置虚路径

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/homeworks/**").addResourceLocations("file:/homework/");
            }
        };
    }
}

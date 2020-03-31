package com.lhb.springboot.controller;

import com.lhb.springboot.entity.tests.User;
import com.lhb.springboot.service.tests.UserService;
import com.lhb.springboot.validator.MyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 04:09 2020/3/6
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService = null;

    @InitBinder
    public void bindValidator(WebDataBinder webDataBinder){
        webDataBinder.setValidator(new MyValidator());
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Map<String,Object> addUser(@RequestBody @Valid User user,Errors errors){
        Map<String,Object> map = new HashMap<String, Object>();
        User flag=null;
        if(errors.hasErrors()) {
            List<ObjectError> oes = errors.getAllErrors();
            for(ObjectError oe:oes){
                if(oe instanceof FieldError){
                    FieldError fe = (FieldError)oe;
                    map.put(fe.getField(),fe.getDefaultMessage());
                }else {
                    map.put(oe.getObjectName(),oe.getDefaultMessage());

                }
            }
        }else{
            flag=userService.addUser(user);
            map.put("status","success");
        }
        map.put("user",user);
        return map;
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/regist";
    }
    //@Scheduled(cron = "*/5 41-41 13 ? * *")
    @RequestMapping("/add")
    @Async
    @ResponseBody
    public User addU(){
        User user = new User("张三",1L,2017108001L);
        User user1 = userService.addUser(user);
        System.out.println("线程【"+Thread.currentThread().getName()+"】:"+"uid:"+user1.getId());
        return user;
    }
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("id",1);
        return "user/testUser";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long sno){
        return userService.findUserBySno(sno);
    }
    @RequestMapping("/delUser")
    @ResponseBody
    public Map<String,Object> delUser(Long sno){
        Map<String,Object> map = new HashMap<String, Object>();
        int flag = userService.deleteUser(sno);
        map.put("success",flag);
        return map;
    }

    @GetMapping("/toRegist")
    public String toRegist(){
        return "/user/regist";
    }

    @PostMapping("/login")
    @ResponseBody
    public User login(@RequestBody User user, HttpSession session, HttpServletRequest request){
        User user1 = userService.findUserBySno(user.getSno());
        if(user1!=null && user1.getUsername().equals(user.getUsername())){
            session.setAttribute("username",user1.getUsername());
            session.setAttribute("level",user1.getLevel());
            request.getSession().setAttribute("userLogin",user1.getUsername());
            request.getSession().setAttribute("level",user1.getLevel());
            return user1;
        }
        return null;
    }
    @RequestMapping("/home")
    public String toHomePage(){
        return "main/home";
    }
    @RequestMapping("/exit")
    public String exit(HttpSession session,HttpServletRequest request){
        session.removeAttribute("username");
        session.removeAttribute("level");
        request.getSession().removeAttribute("userLogin");
        request.getSession().removeAttribute("level");

        return "user/login";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin/home";
    }

    @GetMapping("/test/convert")
    @ResponseBody
    public User stu(User user){
        return user;
    }
}

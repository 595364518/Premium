package com.lhb.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.lhb.springboot.entity.tests.User;
import com.lhb.springboot.entity.users.Email;
import com.lhb.springboot.entity.users.Users;
import com.lhb.springboot.service.tests.UserService;
import com.lhb.springboot.service.users.UsersService;
import com.lhb.springboot.utils.CodeUtil;
import com.lhb.springboot.utils.MailUtil;
import com.lhb.springboot.utils.Result;
import com.lhb.springboot.utils.ResultCode;
import com.lhb.springboot.validator.MyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsersService usersService;

//    @InitBinder
//    public void bindValidator(WebDataBinder webDataBinder){
//        webDataBinder.setValidator(new MyValidator());
//    }

    @GetMapping("/ttt")
    public String ttt(){
        return "testtt";
    }

//    @RequestMapping(value = "/sendsmsTest",method = RequestMethod.GET)
//    @ResponseBody
//    public String sendsmsTest(){
//        //单发短信API
//        String url = "https://open.ucpaas.com/ol/sms/sendsms";
//        JSONObject jsonObject = new JSONObject();
//        //基础配置，在开发平台认证后获取
//        jsonObject.put("sid","b8ad46c454f22066fcb2383d491c3af7");
//        jsonObject.put("token","425c69b496b980308a46304d9c76c713");
//        jsonObject.put("appid","12e9eb95a3f347df9966f299eed00f8d");
//        //模板ID，在开发平台创建模板对应的模板ID
//        jsonObject.put("templateid", "537929");
//        //模板对应的参数，参数之间拼接用逗号作为间隔符
//        jsonObject.put("param", "131550");
//        //要发送的手机号
//        jsonObject.put("mobile", "15244945669");
//        //用户透传ID，随状态报告返回,可以不填写
//        jsonObject.put("uid","");
//        String json = JSONObject.toJSONString(jsonObject);
//        //使用restTemplate进行访问远程服务
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
//        String result = restTemplate.postForObject(url, httpEntity, String.class);
//        return result;
//    }
//
//    @RequestMapping("/addUser")
//    @ResponseBody
//    public Map<String,Object> addUser(@RequestBody @Valid User user,Errors errors){
//        Map<String,Object> map = new HashMap<String, Object>();
//        User flag=null;
//        if(errors.hasErrors()) {
//            List<ObjectError> oes = errors.getAllErrors();
//            for(ObjectError oe:oes){
//                if(oe instanceof FieldError){
//                    FieldError fe = (FieldError)oe;
//                    map.put(fe.getField(),fe.getDefaultMessage());
//                }else {
//                    map.put(oe.getObjectName(),oe.getDefaultMessage());
//
//                }
//            }
//        }else{
//            flag=userService.addUser(user);
//            map.put("status","success");
//        }
//        map.put("user",user);
//        return map;
//    }
//    @RequestMapping("/toAdd")
//    public String toAdd(){
//        return "user/regist";
//    }
//    //@Scheduled(cron = "*/5 41-41 13 ? * *")
//    @RequestMapping("/add")
//    @Async
//    @ResponseBody
//    public User addU(){
//        User user = new User("张三",1L,2017108001L);
//        User user1 = userService.addUser(user);
//        System.out.println("线程【"+Thread.currentThread().getName()+"】:"+"uid:"+user1.getId());
//        return user;
//    }
//    @RequestMapping("/test")
//    public String test(Model model){
//        model.addAttribute("id",1);
//        return "user/testUser";
//    }
//
//    @RequestMapping("/getUser")
//    @ResponseBody
//    public User getUser(Long sno){
//        return userService.findUserBySno(sno);
//    }
//    @RequestMapping("/delUser")
//    @ResponseBody
//    public Map<String,Object> delUser(Long sno){
//        Map<String,Object> map = new HashMap<String, Object>();
//        int flag = userService.deleteUser(sno);
//        map.put("success",flag);
//        return map;
//    }
//
//    @GetMapping("/toRegist")
//    public String toRegist(){
//        return "/user/regist";
//    }
//

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
//
//    @GetMapping("/test/convert")
//    @ResponseBody
//    public User stu(User user){
//        return user;
//    }
}

package com.lhb.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhb.springboot.entity.tests.HomeWork;
import com.lhb.springboot.entity.tests.User;
import com.lhb.springboot.service.tests.HomeWorkService;
import com.lhb.springboot.service.tests.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yaya
 * @Description:
 * @Date: Create in 下午 02:24 2020/3/13
 */
@Controller
public class HomeWorkController {
    @Autowired
    HomeWorkService homeworkService = null;
    @Autowired
    UserService userService = null;


//    @GetMapping("/list")
//    public String listHomework(Model model){
//        List<HomeWork> hWs = homeworkService.findHWs();
//        model.addAttribute("homework",hWs);
//        return "homework/list";
//    }



}

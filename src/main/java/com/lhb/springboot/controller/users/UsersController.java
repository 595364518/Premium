package com.lhb.springboot.controller.users;

import com.lhb.springboot.entity.users.Code;
import com.lhb.springboot.entity.users.Email;
import com.lhb.springboot.entity.users.Grade;
import com.lhb.springboot.entity.users.Users;
import com.lhb.springboot.service.users.EmailService;
import com.lhb.springboot.service.users.GradeService;
import com.lhb.springboot.service.users.UsersService;
import com.lhb.springboot.utils.CodeUtil;
import com.lhb.springboot.utils.MailUtil;
import com.lhb.springboot.utils.Result;
import com.lhb.springboot.utils.ResultCode;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author: yaya
 * @create: 2020/4/4
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private EmailService emailService;
    @Autowired
    GradeService gradeService;
    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     * 通过用户编号检测用户是否已注册
     * @param userId 用户编号
     * @return
     */
    @ResponseBody
    @PostMapping("/checkUser")
    public Result isExists(@RequestParam(value = "userId",required = false) String userId){
        Users users = new Users();
        users.setUserId(Long.parseLong(userId));
        if(usersService.findUserById(users)!=null){
            return new Result(ResultCode.USER_EXISTS.getCode(),
                    ResultCode.USER_EXISTS.getMsg());
        }else{
            return new Result(ResultCode.SUCCESSFUL.getCode(),
                    ResultCode.SUCCESSFUL.getMsg());
        }
    }
    @GetMapping("/sendCode")
    public String validatedCode(){
        return "testtt";
    }
    @GetMapping("/toRegist")
    public String toRegist(){
        return "user/regist";
    }

    /**
     * 验证验证码
     * @param code 验证码信息
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/checkCode")
    public Result checkCode(@RequestBody Code code,
                            HttpServletRequest request){
        HttpSession session = request.getSession();
        String localCo = (String) session.getAttribute("code");
        System.out.println("code:"+code.getCodeName()+"\n"
                +"sessionCode:"+localCo);
        if(localCo != null && localCo != ""){
            if(code.getCodeName().equals(localCo)){
                session.removeAttribute("code");
                    return new Result(ResultCode.SUCCESSFUL.getCode(),
                            ResultCode.SUCCESSFUL.getMsg());
            }else{
                return new Result(ResultCode.WRONG_CODE.getCode(),
                        ResultCode.WRONG_CODE.getMsg());
            }
        }
        return new Result(ResultCode.EMPTY_CODE.getCode(),
                ResultCode.EMPTY_CODE.getMsg());
    }
    @ResponseBody
    @PostMapping("/mailTest")
    public Result mailt(Email e,HttpServletRequest request,String userName){
        String toMail = e.email;
        MailUtil mailUtil = new MailUtil();
        String co = CodeUtil.generateCode();
        HttpSession session = request.getSession();
        try {
            mailUtil.sendEmail(mailSender,"595364518@qq.com",toMail,co ,
                    userName);
            session.setAttribute("code",co);
            return new Result(ResultCode.SUCCESSFUL.getCode(),
                    ResultCode.SUCCESSFUL.getMsg());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Result(ResultCode.FAILED.getCode(),
                ResultCode.FAILED.getMsg());
    }

    @GetMapping("/getGrades")
    @ResponseBody
    public List<Grade> getGrades(){
        List<Grade> list = new ArrayList<>();
        list = gradeService.findAllGrades();
        return list;
    }
    @ResponseBody
    @PostMapping("/checkEmail")
    public Result checkEmail(Email em){
        Email emailByEName = emailService.findEmailByEName(em);
        if(emailByEName != null){
            return new Result(ResultCode.FAILED.getCode(),
                    ResultCode.FAILED.getMsg());
        }
        return new Result(ResultCode.SUCCESSFUL.getCode(),
                ResultCode.SUCCESSFUL.getMsg());

    }
    /**
     * 注册账号
     * @param users 用户信息
     * @param emails 邮箱信息
     * @return
     */
    @ResponseBody
    @PostMapping("/regist")
    public Result regist(Users users, Email emails,Grade grade){
        Grade gradeByName = gradeService.findGradeByName(grade);
        users.setGradeId(gradeByName.getGradeId());
        if(emailService.addEmail(emails) != null){
            Email e = emailService.findEmailByEName(emails);
            users.setEmailId(e.getEmailId());
            if(usersService.addUser(users)!=null){
                return new Result(ResultCode.SUCCESSFUL.getCode(),
                        ResultCode.SUCCESSFUL.getMsg());
            }
            emailService.delEmail(e);
        }
        return new Result(ResultCode.FAILED.getCode(),
                ResultCode.FAILED.getMsg());
    }
}

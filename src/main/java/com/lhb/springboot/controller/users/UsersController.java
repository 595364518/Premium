package com.lhb.springboot.controller.users;

import com.lhb.springboot.entity.users.Code;
import com.lhb.springboot.entity.users.Email;
import com.lhb.springboot.entity.users.Users;
import com.lhb.springboot.service.users.EmailService;
import com.lhb.springboot.service.users.UsersService;
import com.lhb.springboot.utils.Result;
import com.lhb.springboot.utils.ResultCode;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @ResponseBody
    @GetMapping("/checkUser")
    public Result isExists(@RequestParam(value = "userId",required = false)
                                      String userId){
        Users users = new Users();
        if(userId == null || userId == ""){
            return new Result(ResultCode.USER_EMPTY.getCode(),
                    ResultCode.USER_EMPTY.getMsg());
        }else if(usersService.findUserById(users)!=null){
            users.setUserId(Long.parseLong(userId));
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
     * 注册账号
     * @param users 用户信息
     * @param code 验证码
     * @param email 邮箱信息
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/regist")
    public Result regist(@RequestBody Users users,
                         @RequestBody Code code,
                         @RequestBody Email email,
                         HttpServletRequest request){
        HttpSession session = request.getSession();
        String localCo = (String) session.getAttribute("code");
        if(localCo != null && localCo != ""){
            if(code.getCodeName().equals(localCo)){
                System.out.println("code:"+code.getCodeName()+"\n"
                +"sessionCode:"+localCo);
                session.removeAttribute("code");
                if(emailService.addEmail(email)!=null){
                    Email emailByEName = emailService.findEmailByEName(email);
                    users.setEmailId(emailByEName.getEmailId());
                    usersService.addUser(users);
                }
                System.out.println("sessionCode:"+session.getAttribute("code"));
                return new Result(ResultCode.SUCCESSFUL.getCode(),
                        ResultCode.SUCCESSFUL.getMsg());
            }
        }
        return new Result(ResultCode.FAILED.getCode(),
                ResultCode.FAILED.getMsg());
    }
}

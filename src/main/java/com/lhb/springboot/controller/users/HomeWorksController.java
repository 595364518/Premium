package com.lhb.springboot.controller.users;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhb.springboot.entity.tests.HomeWork;
import com.lhb.springboot.entity.users.Grade;
import com.lhb.springboot.entity.users.HomeWorks;
import com.lhb.springboot.entity.users.Times;
import com.lhb.springboot.entity.users.Users;
import com.lhb.springboot.service.users.GradeService;
import com.lhb.springboot.service.users.HomeworksService;
import com.lhb.springboot.service.users.TimesService;
import com.lhb.springboot.service.users.UsersService;
import com.lhb.springboot.utils.DownLoadUtil;
import com.lhb.springboot.utils.Result;
import com.lhb.springboot.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yaya
 * @create: 2020/4/11
 */
@Controller
@RequestMapping("/users/homeworks")
public class HomeWorksController {

    @Autowired
    UsersService usersService;
    @Autowired
    HomeworksService homeworksService;
    @Autowired
    TimesService timesService;
    @Autowired
    GradeService gradeService;

    @GetMapping("/file")
    public String toUpload(){
        return "homework/uploadFile";
    }
    @ResponseBody
    @GetMapping("/getTimes")
    public List<Times> getTimes(){
        List<Times> list = timesService.findAllTimes();
        return list;
    }

    /**
     * 提交作业时检查学生与年级是否匹配
     * @param users 用户
     * @param grade 年级
     * @return
     */
    @ResponseBody
    @GetMapping("/isMatch")
    public Result isMatch(Users users, Grade grade){
        Users userById = usersService.findUserById(users);
        if (userById == null){
            return new Result(ResultCode.SUCCESSFUL.getCode(),
                    ResultCode.SUCCESSFUL.getMsg());
        }else{
            Grade gradeByName = gradeService.findGradeByName(grade);
            if(userById.getGradeId().equals(gradeByName.getGradeId())){
                return new Result(ResultCode.SUCCESSFUL.getCode(),
                        ResultCode.SUCCESSFUL.getMsg());
            }else{
                return new Result(ResultCode.FAILED.getCode(),
                        ResultCode.FAILED.getMsg());
            }
        }
    }
    @PostMapping("/upload")
    public String uploadFile(MultipartFile file, Users users,
                             Times times,Grade grade, Model model){
        String str=null;
        Users u = null;
        //
        String localPath = "f:/homework/";
        String subPath = grade.getGradeName()+"/"
                +times.getTimeName();
        localPath += subPath;
        //
        String fileName=null;
        Map<String,Object> map = new HashMap<>();
        HomeWorks hw = new HomeWorks();
        Times timeByName = timesService.findTimeByName(times.getTimeName());
        if(usersService.findUserById(users)==null){
            Grade gradeByName = gradeService.findGradeByName(grade);
            users.setGradeId(gradeByName.getGradeId());
            u = usersService.addUser(users);
        }
        //
        File file1 = new File(localPath);
        if(!file1.exists()){
            file1.mkdirs();
        }
        //
        try {
            String tmpName=file.getOriginalFilename();
            String []name=tmpName.split("\\.");
            fileName = users.getUserId()+users.getUserName()+"."+name[1];
            //服务器版
            String realPath = localPath+"/"+fileName;
            File file2 = new File(realPath);
            if(!file2.getParentFile().exists()){
                file2.getParentFile().mkdir();
            }
            //
            /**
             * 本地版
             *
             */
            //File file2 = new File(fileName);
            file.transferTo(file2);
        } catch (Exception e) {
            e.printStackTrace();
            str = "文件太大";
            map = statusResult("0",str);
            model.addAttribute("obj",map);
            if(u != null){
                usersService.delUserById(u.getUserId());
            }
            return "homework/fail";
        }
        str="提交成功";
        map = statusResult("1",str);
        model.addAttribute("obj",map);
        hw.setHomeworkName(subPath+"/"+fileName);
        hw.setUserId(users.getUserId());
        hw.setTimeId(timeByName.getTimeId());
        homeworksService.addHomework(hw);
        return "homework/success";
    }
    @GetMapping("/downloadFile")
    public String downLoadVde(HttpServletResponse response, @RequestParam(value = "fileName") String fileName) throws UnsupportedEncodingException {
        String filePath = "f:/homework" ;//本地版
//        String filePath = "/homework" ;//服务器版
        File file = new File(filePath + "/" + fileName);
        DownLoadUtil.download(file,response,fileName);
        return "redirect:/users/homeworks/list";
    }
    @GetMapping("/list")
    public String listCategory(Model m,String para, @RequestParam(value = "start", defaultValue = "1") int start,
                               @RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
        HomeWorks homeWork = new HomeWorks();
        Long sno;
        try{
            sno = Long.parseLong(para);
        }catch (Exception ex){
            sno=null;
        }
        if(sno == null){
            homeWork.setHomeworkName(para);
        }else{
            homeWork.setUserId(sno);
        }
        PageHelper.startPage(start,size,"user_id");
        List<HomeWorks> cs=homeworksService.findHomeworksByIdOrName(homeWork);
        PageInfo<HomeWorks> page = new PageInfo<>(cs);
        m.addAttribute("homework", page);
        return "homework/list";
    }
    public Map<String,Object> statusResult(String str,Object obj){
        Map<String,Object> map = new HashMap<>();
        map.put("status",str);
        map.put("msg",obj);
        return map;
    }
}

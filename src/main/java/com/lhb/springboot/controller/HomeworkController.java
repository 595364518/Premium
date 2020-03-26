package com.lhb.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhb.springboot.entity.HomeWork;
import com.lhb.springboot.entity.User;
import com.lhb.springboot.service.HomeworkService;
import com.lhb.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
public class HomeworkController {
    @Autowired
    HomeworkService homeworkService = null;
    @Autowired
    UserService userService = null;
    @GetMapping("/file")
    public String toUpload(){
        return "homework/uploadFile";
    }
    @PostMapping("/upload")
    public String uploadFile(MultipartFile file,  User user, Model model){
        String str=null;
        //
        String localPath = "/homework";
        //
        String fileName=null;
        Map<String,Object> map = new HashMap<>();
        HomeWork hw = new HomeWork();
        //
        File file1 = new File(localPath);
        if(!file1.exists()){
            file1.mkdirs();
        }
        //
        try {
            String tmpName=file.getOriginalFilename();
            String []name=tmpName.split("\\.");
            fileName = user.getSno()+user.getUsername()+"."+name[1];
            //服务器版
//            String realPath = localPath+"/"+fileName;
//            File file2 = new File(realPath);
//            if(!file2.getParentFile().exists()){
//                file2.getParentFile().mkdir();
//            }
            //
            /**
             * 本地版
             */
            File file2 = new File(fileName);
            file.transferTo(file2);
        } catch (Exception e) {
            e.printStackTrace();
            str = "未选择任何文件或文件太大";
            map = statusResult("0",str);
            model.addAttribute("obj",map);
            return "homework/fail";
        }
        str="上传成功";
        map = statusResult("1",str);
        model.addAttribute("obj",map);
        hw.setHname(fileName);
        hw.setSno(user.getSno());
        homeworkService.addHW(hw);
        if(userService.findUserBySno(user.getSno())==null){
            userService.addUser(user);
        }
        return "homework/success";
    }

//    @GetMapping("/list")
//    public String listHomework(Model model){
//        List<HomeWork> hWs = homeworkService.findHWs();
//        model.addAttribute("homework",hWs);
//        return "homework/list";
//    }
    @GetMapping("/homework")
    public String listCategory(Model m,String para, @RequestParam(value = "start", defaultValue = "1") int start,
                               @RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
        HomeWork homeWork = new HomeWork();
        Long sno;
        try{
            sno = Long.parseLong(para);
        }catch (Exception ex){
            sno=null;
        }
        if(sno == null){
            homeWork.setHname(para);
        }else{
            homeWork.setSno(sno);
        }
        PageHelper.startPage(start,size,"hid");
        List<HomeWork> cs=homeworkService.findHWs(homeWork);
        PageInfo<HomeWork> page = new PageInfo<>(cs);
        m.addAttribute("homework", page);
        return "homework/list";
    }
    @GetMapping("/downloadFile")
    public String downLoadVde(HttpServletResponse response, @RequestParam(value = "fileName") String fileName) throws UnsupportedEncodingException {
        String filePath = "f:/homework" ;//本地版
//        String filePath = "/homework" ;//服务器版
        File file = new File(filePath + "/" + fileName);
        download(file,response,fileName);
        return "redirect:/list";
    }
    private void download(File file,HttpServletResponse response,String fileName) throws UnsupportedEncodingException {
        if(file.exists()){ //判断文件父目录是否存在
            /**
             * 下载文件存在编码问题，待解决！！！
             */
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(fileName,"UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download---" + fileName);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public Map<String,Object> statusResult(String str,Object obj){
        Map<String,Object> map = new HashMap<>();
        map.put("status",str);
        map.put("msg",obj);
        return map;
    }
}

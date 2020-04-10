package com.lhb.springboot.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhb.springboot.entity.Student;
import com.lhb.springboot.entity.tests.HomeWork;
import com.lhb.springboot.entity.tests.User;
import com.lhb.springboot.entity.users.Grade;
import com.lhb.springboot.entity.users.Users;
import com.lhb.springboot.service.users.GradeService;
import com.lhb.springboot.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yaya
 * @create: 2020/4/5
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    UsersService usersService;
    @Autowired
    GradeService gradeService;

    @GetMapping("/studentList")
    public String studenList(Model model,@RequestParam(value = "start", defaultValue = "1") int start,
    @RequestParam(value = "size", defaultValue = "10") int size){
        List<Users> allUsers = usersService.findAllUsers();
        List<Student> list = new ArrayList<>();
        for (Users u:allUsers) {
            Grade grade = new Grade();
            grade.setGradeId(u.getGradeId());
            Grade g = gradeService.findGradeById(grade);
            Student s = new Student(u.getUserName(),u.getUserId(),g.getGradeName());
            list.add(s);
        }
        PageHelper.startPage(start,size);
        PageInfo<Student> page = new PageInfo<>(list);
        model.addAttribute("grade",new Grade());
        model.addAttribute("student", page);
        return "admin/user/user_management";
    }
    @PostMapping("/studentListByGrade")
    public String studentListByGrade(Grade grade,Model model,
                                     @RequestParam(value = "start", defaultValue = "1") int start,
                                     @RequestParam(value = "size", defaultValue = "10") int size){
        List<Student> students = new ArrayList<>();
        List<Users> users;
        if(grade.getGradeName().equals("全部数据")){
            users = usersService.findAllUsers();
            for (Users us:users) {
                Grade grades = new Grade();
                grades.setGradeId(us.getGradeId());
                Grade g = gradeService.findGradeById(grades);
                Student s = new Student(us.getUserName(),us.getUserId(),g.getGradeName());
                students.add(s);
            }
        }else{
            Grade gradeByName = gradeService.findGradeByName(grade);
            users = usersService.findUsersByGradeId(gradeByName.getGradeId());
            for (Users u:users) {
                Student s = new Student(u.getUserName(),u.getUserId(),grade.getGradeName());
                students.add(s);
            }
        }
        PageHelper.startPage(start,size,"grade_id") ;
        PageInfo<Student> page = new PageInfo<>(students);
        model.addAttribute("grade",grade);
        model.addAttribute("student",page);
        return "admin/user/user_management";
    }
    @GetMapping("/toUpdateGrade/{userId}")
    public String toUpdateGrade(@PathVariable(value = "userId")Long userId, Model model){
        Users users = new Users();
        users.setUserId(userId);
        Users userById = usersService.findUserById(users);
        Grade grade = new Grade();
        grade.setGradeId(userById.getGradeId());
        Grade gradeById = gradeService.findGradeById(grade);
        model.addAttribute("grades",gradeById);
        model.addAttribute("user",userById);
        return "admin/user/updateGrade";
    }
    @PostMapping("/updateGrade")
    public String updateGrade(Users users,Grade grade){
        Grade gradeByName = gradeService.findGradeByName(grade);
        users.setGradeId(gradeByName.getGradeId());
        usersService.updateUser(users);
        return "redirect:/admin/studentList";
    }
}

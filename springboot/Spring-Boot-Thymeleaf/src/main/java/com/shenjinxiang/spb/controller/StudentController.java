package com.shenjinxiang.spb.controller;

import com.shenjinxiang.spb.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/9 17:57
 */
@Controller
@RequestMapping("/students")
public class StudentController {

    @RequestMapping("")
    public String index(Model model) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("张三", 15, 1, "一个好人"));
        studentList.add(new Student("李四", 16, 0, "一个老好人"));
        studentList.add(new Student("王五", 17, 1, "一个坏人"));
        studentList.add(new Student("朱六", 18, 0, "一个大坏人"));
        studentList.add(new Student("田七", 20, 1, "一个人！！"));
        model.addAttribute("students", studentList);
        return "student";
    }
}

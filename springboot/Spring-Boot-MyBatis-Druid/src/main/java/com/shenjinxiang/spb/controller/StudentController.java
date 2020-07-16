package com.shenjinxiang.spb.controller;

import com.shenjinxiang.spb.domain.Student;
import com.shenjinxiang.spb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> queryAll() {
        return this.studentService.queryAll();
    }

    @GetMapping("/{id}")
    public Student queryById(@PathVariable("id") int id) {
        return this.studentService.queryById(id);
    }

    @PostMapping("")
    public int add(@RequestBody Student student) {
        return this.studentService.add(student);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable int id, @RequestBody Student student) {
        return this.studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public int delById(@PathVariable("id") int id) {
        return this.studentService.delById(id);
    }
}

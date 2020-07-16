package com.shenjinxiang.spb.service.impl;

import com.shenjinxiang.spb.domain.Student;
import com.shenjinxiang.spb.mapper.StudentMapper;
import com.shenjinxiang.spb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentService")
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryAll() {
        return this.studentMapper.queryAll();
    }

    @Override
    public Student queryById(int id) {
        return this.studentMapper.queryById(id);
    }

    @Override
    public int add(Student student) {
        return this.studentMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return this.studentMapper.update(student);
    }

    @Override
    public int delById(int id) {
        return this.studentMapper.delById(id);
    }
}

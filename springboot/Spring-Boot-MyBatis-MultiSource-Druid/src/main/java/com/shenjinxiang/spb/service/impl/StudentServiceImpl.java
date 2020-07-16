package com.shenjinxiang.spb.service.impl;

import com.shenjinxiang.spb.domain.Student;
import com.shenjinxiang.spb.mapper.db1.StudentMapper;
import com.shenjinxiang.spb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ShenJinXiang
 * @Date: 2020/4/3 17:47
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryAllStudent() {
        return this.studentMapper.queryAllStudent();
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
    public int upd(Student student) {
        return this.studentMapper.upd(student);
    }

    @Override
    public int delById(int id) {
        return this.studentMapper.delById(id);
    }
}

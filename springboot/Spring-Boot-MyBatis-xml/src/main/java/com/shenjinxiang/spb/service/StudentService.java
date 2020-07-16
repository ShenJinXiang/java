package com.shenjinxiang.spb.service;

import com.shenjinxiang.spb.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> queryAll();

    Student queryById(int id);

    int add(Student student);

    int update(Student student);

    int delById(int id);
}

package com.shenjinxiang.spb.mapper;

import com.shenjinxiang.spb.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {

    List<Student> queryAll();

    Student queryById(int id);

    int add(Student student);

    int update(Student student);

    int delById(int id);
}

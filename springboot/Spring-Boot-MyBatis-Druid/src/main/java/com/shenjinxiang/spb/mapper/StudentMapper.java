package com.shenjinxiang.spb.mapper;

import com.shenjinxiang.spb.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {

    @Select("select `id`, `name`, `age`, `sex`, `desc` from student")
    @Results(id = "queryAll", value = {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "age", column = "age", javaType = Integer.class),
            @Result(property = "sex", column = "sex", javaType = Integer.class),
            @Result(property = "desc", column = "desc", javaType = String.class)
    })
    List<Student> queryAll();

    @Select("select `id`, `name`, `age`, `sex`, `desc` from student where `id` = #{id}")
    @Results(id = "queryById", value = {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "age", column = "age", javaType = Integer.class),
            @Result(property = "sex", column = "sex", javaType = Integer.class),
            @Result(property = "desc", column = "desc", javaType = String.class)
    })
    Student queryById(int id);

    @Insert("insert into student (`name`, `age`, `sex`, `desc`) values (#{name}, #{age}, #{sex}, #{desc})")
    int add(Student student);

    @Update("update student set `name` = #{name}, `age` = #{age}, `sex` = #{sex}, `desc` = #{desc} where `id` = #{id}")
    int update(Student student);

    @Delete("delete from student where `id` = #{id}")
    int delById(int id);

}

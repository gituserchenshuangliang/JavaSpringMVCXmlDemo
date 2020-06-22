package com.spring.service;

import com.spring.entity.Student;

import java.util.ArrayList;

/**
 * @description:Service接口
 * @author: Cherry
 * @time: 2020/6/12 12:38
 */
public interface StudentService {

    Student findOne(int uuid);

    int addStudent(Student Student);

    ArrayList<Student> findByClassId(int classId);
}

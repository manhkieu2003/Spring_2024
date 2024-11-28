package org.example.luyentap.service.ImplStudent;

import org.example.luyentap.model.Student;

import java.util.List;

public interface ImStudent {
    List<Student> findAll();
    Student findStudentById(int id);
    Student saveStudent(Student student);
}

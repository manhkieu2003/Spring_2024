package org.example.luyentap.repository.ImStudentRepo;

import org.example.luyentap.model.Student;

import java.util.List;

public interface ImStudentRepository {
    List<Student> fillAllStudents();
    Student getStudentById(int id);
    Student saveStudent(Student student);
}

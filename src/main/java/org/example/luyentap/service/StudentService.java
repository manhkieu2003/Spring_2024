package org.example.luyentap.service;

import org.example.luyentap.model.Student;
import org.example.luyentap.repository.ImStudentRepo.ImStudentRepository;
import org.example.luyentap.repository.StudentRepository;
import org.example.luyentap.service.ImplStudent.ImStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements ImStudent {
    @Autowired
    StudentRepository studentRepository;
    //ImStudentRepository studentRepository= new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.fillAllStudents();
    }
    @Override
    public Student findStudentById(int id) {
        return studentRepository.getStudentById(id);
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.saveStudent(student);
    }
}

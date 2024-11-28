package org.example.luyentap.repository;

import org.example.luyentap.model.Student;
import org.example.luyentap.repository.ImStudentRepo.ImStudentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class StudentRepository implements ImStudentRepository {
    public List<Student> students = new ArrayList<Student>(


            Arrays.asList(
                    new Student(1,"kieuducmanh",8.0),
                    new Student(2,"nguyễn mai anh",9.0)
            )
    );
    public List<Student> fillAllStudents() {
        return students;
    }
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public Student saveStudent(Student student) {
        student.setId(students.size()+1);
        students.add(student);
        return student;
    }
}

package org.example.luyentap.controller;

import org.example.luyentap.Exception.ApiException;
import org.example.luyentap.Exception.ErrorCode;
import org.example.luyentap.dto.ApiResponse;
import org.example.luyentap.model.Student;
import org.example.luyentap.service.ImplStudent.ImStudent;
import org.example.luyentap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hocsinh")
public class StudentController {
    @Autowired //DI ->tiem su phu thuoc : 3 cach tiem
   StudentService studentService; //=> tiem qua thuoc tinh
    // Tiem qua contructor
   // StudentService studentService;
//    @Autowired // k cần cũng dc
//    public StudentController(StudentService studentService )
//    {
//        this.studentService=studentService;
//    }
    // tiem qua setter
   //StudentService studentService;
//    @Autowired
//    public void setStudentService(StudentService studentService) {
//        this.studentService = studentService;
//    }

   // ImStudent studentService = new StudentService();
     @GetMapping()
     // tương đương
    // @RequestMapping(value = "/hocsinh",method = RequestMethod.GET)
   public ResponseEntity<ApiResponse<List<Student>>> getStudents() {
       return ResponseEntity.ok(ApiResponse.<List<Student>>builder().data(studentService.findAll()).build());
   }
     @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getById(@PathVariable int id) {
         // day la theo mo hinh mvc roi
         Student student = studentService.findStudentById(id);
         if (student == null) {
             throw new ApiException(ErrorCode.TEACH_NOT_EXIST);
         }
         return ResponseEntity.ok(ApiResponse.<Student>builder().data(student).build());

         //=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         // nếu trả về student thì mặc định sẽ là 200 car kể id k có
         // dùng reposeEntity
//         for (Student student : studentService.findAll()) {
//             if (student.getId() == id) {
//                 //return ResponseEntity.status(HttpStatus.OK).body(student);
//                 //viết 200 hoac httpstatus.ok
//                 // ngắn gon hơn
//                 //return ResponseEntity.ok(new ApiResponse<>(200,"thành công",student));
//                 // ngắn gọn hơn vif có @Buider bên apiresponse
//                 return  ResponseEntity.ok(ApiResponse.<Student>builder()
//                         .data(student).build()); // nếu ko truyen code message thi mac dinh la null sẽ bij mất nếu @jsoninclude ben apirepose
//
//
//             }
//         }
       //  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(404," ko thành công",null));
        // return ResponseEntity.notFound().build();
         // cacách khác

         // exception
        // throw new ApiException(ErrorCode.TEACH_NOT_EXIST);
       //  return  ResponseEntity.status(ErrorCode.STUDENT_NOT_EXIST.getStatus()).body(ApiResponse.<Student>builder().code(ErrorCode.STUDENT_NOT_EXIST.getCode()).message(ErrorCode.STUDENT_NOT_EXIST.getMessage()).build()); //datata mac dinh la null


     }
     @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody Student student) { // ? se la apirepose <student>
         // su dung mvc
         Student newStudent = studentService.saveStudent(student);
         if (newStudent == null) {
             throw new ApiException(ErrorCode.TEACH_NOT_EXIST);
         }
         return ResponseEntity.ok(ApiResponse.<Student>builder().data(newStudent).build());
         //=>>>>>>>>>>>>>>>>>>>>>>>>>
//          student.setId(studentService.findAll().size() + 1);
//          studentService.findAll().add(student);
//          return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<Student>builder().data(student).build());
     }
}

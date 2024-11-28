package org.example.luyentap.controller;

import lombok.Getter;
import org.example.luyentap.Exception.ApiException;
import org.example.luyentap.Exception.ErrorCode;
import org.example.luyentap.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hocsinh")
public class StudentController {

    public List<Student>  students = new ArrayList<Student>(


           Arrays.asList(
                   new Student(1,"kieuducmanh",8.0),
                   new Student(2,"nguyễn mai anh",9.0)
                   )
    );
     @GetMapping()
     // tương đương
    // @RequestMapping(value = "/hocsinh",method = RequestMethod.GET)
   public ResponseEntity<ApiResponse<List<Student>>> getStudents() {
       return ResponseEntity.ok(new ApiResponse<>(null,null,students));
   }
     @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getById(@PathVariable int id) {
         // nếu trả về student thì mặc định sẽ là 200 car kể id k có
         // dùng reposeEntity
         for (Student student : students) {
             if (student.getId() == id) {
                 //return ResponseEntity.status(HttpStatus.OK).body(student);
                 //viết 200 hoac httpstatus.ok
                 // ngắn gon hơn
                 //return ResponseEntity.ok(new ApiResponse<>(200,"thành công",student));
                 // ngắn gọn hơn vif có @Buider bên apiresponse
                 return  ResponseEntity.ok(ApiResponse.<Student>builder()
                         .data(student).build()); // nếu ko truyen code message thi mac dinh la null sẽ bij mất nếu @jsoninclude ben apirepose


             }
         }
       //  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(404," ko thành công",null));
        // return ResponseEntity.notFound().build();
         // cacách khác

         // exception
         throw new ApiException(ErrorCode.TEACH_NOT_EXIST);
       //  return  ResponseEntity.status(ErrorCode.STUDENT_NOT_EXIST.getStatus()).body(ApiResponse.<Student>builder().code(ErrorCode.STUDENT_NOT_EXIST.getCode()).message(ErrorCode.STUDENT_NOT_EXIST.getMessage()).build()); //datata mac dinh la null


     }
     @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody Student student) { // ? se la apirepose <student>
          student.setId(students.size() + 1);
          students.add(student);
          return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<Student>builder().data(student).build());
     }
}

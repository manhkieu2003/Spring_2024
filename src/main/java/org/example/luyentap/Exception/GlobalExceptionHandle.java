package org.example.luyentap.Exception;

import org.example.luyentap.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
// controlleradvice de nang nghe
public class GlobalExceptionHandle {
    @ExceptionHandler(ApiException.class) // nang nghe thang apiException
    public ResponseEntity<?> handleApiException(ApiException e) {
           ErrorCode errorCode = e.getErrorCode();  // e.getErrorCode chinh la thang nay ErrorCode.STUDENT_NOT_EXIST
          return  ResponseEntity.status(errorCode.getStatus()).body(ApiResponse.builder().code(errorCode.getCode()).message(errorCode.getMessage()).build()); //datata mac dinh la null

    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException e) {
        return  null;
    }
}

package org.example.luyentap.Exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    STUDENT_NOT_EXIST(40401,"không thành côngsssSTD",HttpStatus.NOT_FOUND),
    TEACH_NOT_EXIST(40402,"không thành côngsssTCH",HttpStatus.NOT_FOUND);

    Integer code;
    String message;
    HttpStatus status;
}

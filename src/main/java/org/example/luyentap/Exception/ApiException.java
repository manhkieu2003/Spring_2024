package org.example.luyentap.Exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.hibernate.event.spi.SaveOrUpdateEvent;
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class ApiException extends RuntimeException {
    ErrorCode errorCode;
    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}

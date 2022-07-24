package az.company.turbo.controller;

import az.company.turbo.dto.ErrorResponse;
import az.company.turbo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(RuntimeException ex) {
        return  ErrorResponse
                .builder()
                .code(301)
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
    }
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ErrorResponse handleRuntimeException(RuntimeException ex) {
//        return  ErrorResponse
//                .builder()
//                .code(301)
//                .dateTime(LocalDateTime.now())
//                .message(ex.getMessage())
//                .build();
//    }


}

package com.example.demo.configs.exeptions

import com.example.demo.dtos.except.FieldValidationErrorDto
import com.example.demo.dtos.except.RequestValidationErrors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun handleNotArgsNotValidExcept(exception: MethodArgumentNotValidException): ResponseEntity<Any>? {
        var errorsDtoList = exception.getFieldErrors()
            .map { FieldValidationErrorDto(it.field, it.defaultMessage ?: "") }

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(RequestValidationErrors(errorsDtoList));
    }
}
package com.example.demo.dtos.except

data class RequestValidationErrors(
    val fieldValidationErrorDtoList: List<FieldValidationErrorDto>
)

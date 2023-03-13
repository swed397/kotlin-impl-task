package com.example.demo.dtos.except

data class FieldValidationErrorDto(
    val fieldName: String,
    val errorMsg: String
)
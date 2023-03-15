package com.example.demo.dtos.movie

import com.example.demo.valid.ValidateMovieType
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class MovieCreateDto(

    @NotBlank(message = "Name is NOT NULL constraint")
    val name: String,

    @NotBlank(message = "Name is NOT NULL constraint")
    val comment: String,

    @ValidateMovieType
    val type: String,

    @NotBlank(message = "Genre is NOT NULL constraint")
    val genre: String,

    @NotBlank(message = "Date is NOT NULL constraint")
    val date: LocalDate
)

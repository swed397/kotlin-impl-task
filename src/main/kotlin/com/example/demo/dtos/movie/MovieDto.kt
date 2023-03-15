package com.example.demo.dtos.movie

import java.time.LocalDate

data class MovieDto(
    val id: Long,
    val name: String,
    val comment: String,
    val type: String,
    val genre: String,
    val date: LocalDate,
)

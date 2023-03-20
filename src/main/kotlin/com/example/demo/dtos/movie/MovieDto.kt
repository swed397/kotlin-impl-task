package com.example.demo.dtos.movie

import java.util.*

data class MovieDto(
    val id: Long,
    val name: String,
    val comment: String,
    val type: String,
    val genre: String,
    val date: Date,
)

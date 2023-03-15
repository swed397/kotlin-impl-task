package com.example.demo.services.interfaces

import com.example.demo.entities.Movie

interface MovieService {

    fun save(movie: Movie): Movie

    fun findAll(page: Int, size: Int): List<Movie>

    fun findAllByName(name: String): List<Movie>

    fun findAllByType(type: String): List<Movie>

    fun findAllByYear(year: Int): List<Movie>
}
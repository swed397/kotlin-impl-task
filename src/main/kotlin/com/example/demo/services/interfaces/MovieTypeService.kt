package com.example.demo.services.interfaces

import com.example.demo.entities.MovieType

interface MovieTypeService {

    fun checkMovieTypeExisting(type: String): Boolean

    fun findTypeByName(name: String): MovieType

    fun findAll(): List<MovieType>
}
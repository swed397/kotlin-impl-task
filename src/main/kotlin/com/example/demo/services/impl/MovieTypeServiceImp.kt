package com.example.demo.services.impl

import com.example.demo.entities.MovieType
import com.example.demo.repositories.MovieTypeRepository
import com.example.demo.services.interfaces.MovieTypeService
import org.springframework.stereotype.Service

@Service
class MovieTypeServiceImp(
    val repository: MovieTypeRepository
) : MovieTypeService {

    override fun checkMovieTypeExisting(type: String): Boolean = repository.findByNameIgnoreCase(type) != null

    override fun findTypeByName(name: String): MovieType =
        repository.findByNameIgnoreCase(name) ?: MovieType(null, null)

    override fun findAll(): List<MovieType> = repository.findAll()
}
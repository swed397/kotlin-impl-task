package com.example.demo.services.impl

import com.example.demo.entities.Movie
import com.example.demo.repositories.MovieRepository
import com.example.demo.services.interfaces.MovieService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MovieServiceImpl(
    val repository: MovieRepository,
) : MovieService {
    private val logger = LoggerFactory.getLogger(javaClass)


    override fun save(movie: Movie): Movie {
        val savedMovie = repository.save(movie)
        if (savedMovie.id != null) {
            logger.info("Successfully saved new movie");
        }

        return savedMovie
    }

    override fun findAll(page: Int, size: Int): List<Movie> = repository.findAll(PageRequest.of(page, size)).content

    override fun findAllByName(name: String): List<Movie> = repository.findAllByNameContainingIgnoreCase(name)

    override fun findAllByType(type: String): List<Movie> = repository.findAllByType_NameIgnoreCase(type)

    override fun findAllByYear(year: Int): List<Movie> = repository.findAllByYear(year)
}
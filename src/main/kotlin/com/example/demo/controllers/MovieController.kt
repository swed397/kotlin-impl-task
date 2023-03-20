package com.example.demo.controllers

import com.example.demo.dtos.movie.MovieCreateDto
import com.example.demo.dtos.movie.MovieDto
import com.example.demo.mappers.MovieMapper
import com.example.demo.services.interfaces.MovieService
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("")
@Validated
class MovieController(
    val movieService: MovieService,
    val movieMapper: MovieMapper
) {
    private val logger = LoggerFactory.getLogger(javaClass)


    @PostMapping("/add")
    fun save(@RequestBody @Valid movieCreateDto: MovieCreateDto): ResponseEntity<MovieDto> {
        logger.info("saving new movie ...")
        val movie = movieService.save(movieMapper.toEntity(movieCreateDto))

        return ResponseEntity.ok(movieMapper.toDto(movie))
    }

    @PostMapping("/addAll")
    fun saveAll(@RequestBody @Valid movieCreateDtoList: List<MovieCreateDto>): ResponseEntity<Any> {
        logger.info("Saving new list of movie, size of : ${movieCreateDtoList.size}")
        movieCreateDtoList.forEach { movieService.save(movieMapper.toEntity(it)) }
        logger.info("Saving list of movies")

        return ResponseEntity.ok().build()
    }

    @GetMapping("/findByName{name}")
    fun findAllByName(@PathVariable name: String): ResponseEntity<List<MovieDto>> {
        logger.info("Getting movies by name : $name")
        return ResponseEntity.ok(movieService.findAllByName(name).map { movieMapper.toDto(it) })
    }

    @GetMapping("/findByType{type}")
    fun findAllByType(@PathVariable type: String): ResponseEntity<List<MovieDto>> {
        logger.info("Getting movies by type : $type")
        return ResponseEntity.ok(movieService.findAllByType(type).map { movieMapper.toDto(it) })
    }

    @GetMapping("/findByYear{year}")
    fun findAllByYear(@PathVariable year: Int): ResponseEntity<List<MovieDto>> {
        logger.info("Getting movies by year : $year")
        return ResponseEntity.ok(movieService.findAllByYear(year).map { movieMapper.toDto(it) })
    }

    @GetMapping("/getAll&&page={page}&&size={size}")
    fun findAll(@PathVariable page: Int, @PathVariable size: Int): ResponseEntity<List<MovieDto>> {
        logger.info("Get all movies on page $page")
        return ResponseEntity.ok(movieService.findAll(page, size).map { movieMapper.toDto(it) })
    }
}
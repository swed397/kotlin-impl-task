package com.example.demo.mappers

import com.example.demo.dtos.movie.MovieCreateDto
import com.example.demo.dtos.movie.MovieDto
import com.example.demo.entities.Movie
import com.example.demo.entities.MovieType
import com.example.demo.services.interfaces.MovieTypeService
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
abstract class MovieMapper {

    @Autowired
    lateinit var movieTypeService: MovieTypeService


    @Mapping(source = "type", target = "type", qualifiedByName = ["typeToStr"])
    abstract fun toDto(source: Movie): MovieDto

    @Mapping(source = "type", target = "type", qualifiedByName = ["strToType"])
    @Mapping(target = "id", ignore = true)
    abstract fun toEntity(source: MovieCreateDto): Movie

    @Named(value = "typeToStr")
    fun typeToStr(type: MovieType): String = type.name ?: ""

    @Named(value = "strToType")
    fun strToType(type: String): MovieType = movieTypeService.findTypeByName(type)
}
package com.example.demo.repositories

import com.example.demo.entities.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface MovieRepository : JpaRepository<Movie, Long>, PagingAndSortingRepository<Movie, Long> {

    fun findAllByNameContainingIgnoreCase(name: String): List<Movie>

    fun findAllByType_NameIgnoreCase(movieType: String): List<Movie>

    @Query(value = "select m from Movie m where year(m.date) = :#{#year}")
    fun findAllByYear(@Param("year") year: Int): List<Movie>
}
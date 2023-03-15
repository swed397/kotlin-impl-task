package com.example.demo.repositories

import com.example.demo.entities.MovieType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieTypeRepository : JpaRepository<MovieType, Long> {

    fun findByNameIgnoreCase(name: String): MovieType?
}
package com.example.demo.entities

import jakarta.persistence.*

@Entity
@Table(name = "movie_type")
data class MovieType(

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "name")
    var name: String?
)

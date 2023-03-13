package com.example.demo.entities

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.util.Date

data class Movie(

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "name")
    var name: String?,

    @Column(name = "comment")
    var comment: String?,

    @OneToOne
    @JoinColumn(name = "movie_type_id")
    var movieType: MovieType,

    @Column(name = "genre")
    var genre: String?,

    @Column(name = "date")
    var date: Date?
)

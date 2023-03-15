package com.example.demo.entities

import jakarta.persistence.*
import java.time.LocalDate
import java.util.Date

@Entity
@Table(name = "movies")
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
    var type: MovieType,

    @Column(name = "genre")
    var genre: String?,

    @Column(name = "date")
    var date: LocalDate?
)

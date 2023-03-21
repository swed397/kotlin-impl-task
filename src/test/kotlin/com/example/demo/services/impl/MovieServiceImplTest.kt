package com.example.demo.services.impl

import com.example.demo.entities.Movie
import com.example.demo.entities.MovieType
import com.example.demo.repositories.MovieRepository
import com.example.demo.services.interfaces.MovieService
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDate

//@SpringBootTest(classes = [ProjectConfig::class])
@SpringBootTest
//@ExtendWith(SpringExtension::class)
class MovieServiceImplTest : FunSpec() {

    @MockK
    lateinit var movieRepository: MovieRepository

    @Autowired
    lateinit var movieService: MovieService;

    val testMovie = Movie(
        1L, "Test film", "TEST", MovieType(1L, "TEST"), "TEST", LocalDate.now()
    )

    init {
        beforeEach { MockKAnnotations.init(this) }


        beforeEach {
            every {
                movieRepository.save(any())
            } returns
                    testMovie
        }

        beforeEach {
            every {
                movieRepository.findAll()
            } returns
                    listOf(testMovie, testMovie, testMovie)
        }

        test("save")
        {
            movieService.save(
                Movie(
                    null, "Test film", "TEST", MovieType(1L, "TEST"),
                    "TEST", LocalDate.now()
                )
            ).id shouldBe 1
        }

        test("findAll")
        {}

        test("findAllByName")
        {}

        test("findAllByType")
        {}

        test("findAllByYear")
        {}
    }
}

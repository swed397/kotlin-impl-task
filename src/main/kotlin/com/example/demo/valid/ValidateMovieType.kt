package com.example.demo.valid

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [MovieTypeValidator::class])
annotation class ValidateMovieType (
    val message: String = "Invalid movie type",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

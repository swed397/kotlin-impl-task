package com.example.demo.valid

import com.example.demo.services.interfaces.MovieTypeService
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import org.springframework.stereotype.Component

@Component
class MovieTypeValidator(
    val movieTypeService: MovieTypeService
) : ConstraintValidator<ValidateMovieType, String> {

    override fun isValid(type: String, constraintValidatorContext: ConstraintValidatorContext): Boolean {
        constraintValidatorContext.disableDefaultConstraintViolation()
        constraintValidatorContext.buildConstraintViolationWithTemplate(
            String.format(
                "Invalid movie type. Available: %s",
                movieTypeService.findAll().joinToString("; ") { it.name ?: "" }) + "."
        ).addConstraintViolation()

        return movieTypeService.checkMovieTypeExisting(type)
    }
}
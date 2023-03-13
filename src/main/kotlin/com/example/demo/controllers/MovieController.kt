package com.example.demo.controllers

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class MovieController {
    private val logger = LoggerFactory.getLogger(javaClass)


    @GetMapping("/test")
    fun testHelloWord(): ResponseEntity<String> {
        logger.info("ALL WORKS")
        return ResponseEntity.status(HttpStatus.OK).body("HELLO WORD!")
    }
}
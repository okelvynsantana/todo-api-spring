package com.kelvynsantana.todoapi.controllers

import com.kelvynsantana.todoapi.dataClasses.GenericResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
@Tag(name = "Health")
class HealthController {
    @GetMapping("/")
    fun health() = GenericResponse(true, "Api running")
}
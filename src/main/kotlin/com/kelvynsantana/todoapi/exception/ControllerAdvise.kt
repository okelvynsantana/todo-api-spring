package com.kelvynsantana.todoapi.exception

import com.kelvynsantana.todoapi.enums.ResponseStatusEnum
import com.kelvynsantana.todoapi.errors.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvise {

    @ExceptionHandler(NotfoundException::class)
    fun handleException(ex: NotfoundException, r: WebRequest): ResponseEntity<ErrorResponse> {
        val error =
            ErrorResponse(
                httpCode = HttpStatus.NOT_FOUND.value(),
                status = ResponseStatusEnum.info,
                message = ex.message,
                technicalMessage = ex.technicalMessage,
                internalCode = ex.internalCode,

            )

        return ResponseEntity(error, HttpStatus.NOT_FOUND)

    }

}
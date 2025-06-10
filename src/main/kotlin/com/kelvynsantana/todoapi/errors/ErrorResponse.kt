package com.kelvynsantana.todoapi.errors

import com.kelvynsantana.todoapi.enums.ResponseStatusEnum

data class ErrorResponse (
    var httpCode: Int,
    var message: String,
    var status: ResponseStatusEnum,
    var technicalMessage: String,
    var internalCode: String,

)



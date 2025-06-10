package com.kelvynsantana.todoapi.exception

class NotfoundException(
    override val message: String,
    val internalCode: String,
    val technicalMessage: String,
): Exception() {
}
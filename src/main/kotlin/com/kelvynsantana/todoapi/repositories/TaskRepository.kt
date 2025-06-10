package com.kelvynsantana.todoapi.repositories

import com.kelvynsantana.todoapi.dataClasses.Task
import org.springframework.data.repository.CrudRepository
import java.util.UUID
import java.util.Optional

interface TaskRepository: CrudRepository<Task, UUID> {

    fun findByTitle(title: String): Optional<Task>
}
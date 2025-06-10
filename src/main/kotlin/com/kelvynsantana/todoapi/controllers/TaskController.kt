package com.kelvynsantana.todoapi.controllers

import com.kelvynsantana.todoapi.services.TaskService
import com.kelvynsantana.todoapi.dataClasses.GenericResponse
import com.kelvynsantana.todoapi.dataClasses.Task
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/tasks")
@Tag(name = "Tasks")
class TaskController(private val taskService: TaskService) {
    @GetMapping("/")
    fun allTasks(): List<Task> {
        return taskService.getAllTasks()
    }

    @PostMapping("/")
    fun add(@RequestBody task: Task): Task {
        val newTask: Task = taskService.createTask(title = task.title, description = task.description);
        return newTask
    }

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: UUID): Task? {
        return taskService.getTaskByID((id));
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody task: Task): Task {
        return taskService.updateTask(id, title = task.title, description = task.description);
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): GenericResponse {
        return GenericResponse(true, "Successfully deleted the task")
    }
}
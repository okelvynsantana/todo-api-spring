package com.kelvynsantana.todoapi.services

import com.kelvynsantana.todoapi.dataClasses.Task
import com.kelvynsantana.todoapi.exception.NotfoundException
import com.kelvynsantana.todoapi.repositories.TaskRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
public class TaskService(private val taskRepository: TaskRepository) {

    fun createTask(title: String, description: String): Task {
        val task = Task(title = title, description = description)
        taskRepository.save(task)

        return task
    }

    fun getTaskByID(id: UUID): Task? {

        val task = taskRepository.findById(id).orElseThrow{
            NotfoundException(message = "Task with id $id does not exist", internalCode = "TODO-001", technicalMessage = "Not found" )
        }

        return task

    }


    fun updateTask(id: UUID, title: String, description: String): Task {
        val task = taskRepository.findById(id).orElseThrow{
            NotfoundException(message = "Task with id $id does not exist", internalCode = "TODO-001", technicalMessage = "Not found" )
        }


        val taskInstance = task.copy(title = title, description = description)
        taskRepository.save(taskInstance)

        return taskInstance

    }


    fun getAllTasks(): List<Task> {
        val tasks = taskRepository.findAll().toList()

        return tasks
    }


}
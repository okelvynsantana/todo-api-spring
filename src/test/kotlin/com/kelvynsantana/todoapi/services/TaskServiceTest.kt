package com.kelvynsantana.todoapi.services

import com.kelvynsantana.todoapi.dataClasses.Task
import com.kelvynsantana.todoapi.exception.NotfoundException
import com.kelvynsantana.todoapi.repositories.TaskRepository
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class TaskServiceTest {
    @MockK
    private lateinit var taskRepository: TaskRepository

    @InjectMockKs
    private lateinit var taskService: TaskService

    private lateinit var mockTask: Task
    private lateinit var taskId: UUID

    @BeforeEach
    fun setup() {
        taskId = UUID.randomUUID()
        mockTask = Task(
            id = taskId,
            title = "Test Task",
            description = "Test Description"
        )
    }

    @Test
    fun `createTask should create and return a new task`() {
        // Given
        val title = "New Task"
        val description = "New Description"
        val expectedTask = Task(title = title, description = description)
        
        coEvery { taskRepository.save(any()) } returns expectedTask

        // When
        val result = taskService.createTask(title, description)

        // Then
        assertEquals(title, result.title)
        assertEquals(description, result.description)
        coVerify { taskRepository.save(any()) }
    }

    @Test
    fun `getTaskByID should return task when it exists`() {
        // Given
        coEvery { taskRepository.findById(taskId) } returns Optional.of(mockTask)

        // When
        val result = taskService.getTaskByID(taskId)

        // Then
        assertNotNull(result)
        assertEquals(taskId, result?.id)
        assertEquals(mockTask.title, result?.title)
        assertEquals(mockTask.description, result?.description)
        coVerify { taskRepository.findById(taskId) }
    }

    @Test
    fun `getTaskByID should throw NotfoundException when task does not exist`() {
        // Given
        coEvery { taskRepository.findById(taskId) } returns Optional.empty()

        // When/Then
        val exception = assertThrows(NotfoundException::class.java) {
            taskService.getTaskByID(taskId)
        }
        assertEquals("Task with id $taskId does not exist", exception.message)
        assertEquals("TODO-001", exception.internalCode)
        coVerify { taskRepository.findById(taskId) }
    }

    @Test
    fun `updateTask should update and return task when it exists`() {
        // Given
        val newTitle = "Updated Title"
        val newDescription = "Updated Description"
        val updatedTask = mockTask.copy(title = newTitle, description = newDescription)
        
        coEvery { taskRepository.findById(taskId) } returns Optional.of(mockTask)
        coEvery { taskRepository.save(any()) } returns updatedTask

        // When
        val result = taskService.updateTask(taskId, newTitle, newDescription)

        // Then
        assertEquals(newTitle, result.title)
        assertEquals(newDescription, result.description)
        coVerify { 
            taskRepository.findById(taskId)
            taskRepository.save(any())
        }
    }

    @Test
    fun `updateTask should throw NotfoundException when task does not exist`() {
        // Given
        coEvery { taskRepository.findById(taskId) } returns Optional.empty()

        // When/Then
        val exception = assertThrows(NotfoundException::class.java) {
            taskService.updateTask(taskId, "New Title", "New Description")
        }
        assertEquals("Task with id $taskId does not exist", exception.message)
        assertEquals("TODO-001", exception.internalCode)
        coVerify { taskRepository.findById(taskId) }
        coVerify(exactly = 0) { taskRepository.save(any()) }
    }

    @Test
    fun `getAllTasks should return list of all tasks`() {
        // Given
        val tasks = listOf(
            Task(title = "Task 1", description = "Description 1"),
            Task(title = "Task 2", description = "Description 2")
        )
        coEvery { taskRepository.findAll() } returns tasks

        // When
        val result = taskService.getAllTasks()

        // Then
        assertEquals(2, result.size)
        assertEquals(tasks, result)
        coVerify { taskRepository.findAll() }
    }
}
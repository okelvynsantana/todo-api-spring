package com.kelvynsantana.todoapi.dataClasses

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    @Column(nullable = false)
    val title: String,
    @Column(nullable = false)
    val description: String,

    @Column(updatable = false, nullable = false)
    @CreatedDate
    val createdDate: LocalDateTime? = LocalDateTime.now(),

    @Column(nullable = false)
    @LastModifiedDate
    var modifiedDate: LocalDateTime? = LocalDateTime.now(),
)

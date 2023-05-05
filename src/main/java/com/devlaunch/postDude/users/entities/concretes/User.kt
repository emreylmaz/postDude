package com.devlaunch.postDude.users.entities.concretes

import com.devlaunch.postDude.common.entities.abstracts.BaseEntity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.util.*

data class User (
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id : UUID? = null,
        val username : String,
        val email : String,
        val password : String,
        override val createdAt: LocalDateTime,
        override val updatedAt: LocalDateTime,
        override val deletedAt: LocalDateTime
        ) : BaseEntity(createdAt, updatedAt, deletedAt)

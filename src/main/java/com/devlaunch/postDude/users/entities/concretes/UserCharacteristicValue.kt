package com.devlaunch.postDude.users.entities.concretes

import com.devlaunch.postDude.common.entities.abstracts.BaseEntity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.util.*

data class UserCharacteristicValue(
        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val characteristicValueId : UUID? = null,
        val value : String,
        val characteristicId : UUID,
        val userId : UUID,
        override val createdAt: LocalDateTime,
        override val updatedAt: LocalDateTime,
        override val deletedAt: LocalDateTime
    ): BaseEntity(createdAt, updatedAt, deletedAt)

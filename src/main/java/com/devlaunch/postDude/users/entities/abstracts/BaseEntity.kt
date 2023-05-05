package com.devlaunch.postDude.users.entities.abstracts

import jakarta.persistence.Column
import jakarta.persistence.Entity
import java.time.LocalDateTime


abstract class BaseEntity(open val createdAt: LocalDateTime,
                          open val updatedAt: LocalDateTime,
                          open val deletedAt: LocalDateTime)

package com.devlaunch.postDude.common.entities.abstracts

import java.time.LocalDateTime


abstract class BaseEntity(open val createdAt: LocalDateTime,
                          open val updatedAt: LocalDateTime,
                          open val deletedAt: LocalDateTime
)
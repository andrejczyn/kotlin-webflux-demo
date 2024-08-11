package com.andrejczyn.kfd.client

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.time.Instant
import java.util.UUID

interface UserService {
    @GetMapping("/{userId}")
    suspend fun user(
        @PathVariable userId: UUID,
    ): User
}

data class User(
    val id: UUID,
    val firstname: String,
    val surname: String,
    val createdAt: Instant,
)

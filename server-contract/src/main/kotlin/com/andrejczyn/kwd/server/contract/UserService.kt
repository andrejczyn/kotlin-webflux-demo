package com.andrejczyn.kwd.server.contract

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import java.time.Instant
import java.util.UUID

interface UserService {
    @GetExchange("/users/{userId}")
    suspend fun user(
        @PathVariable userId: UUID,
        @RequestParam waitTime: Long = 1000,
    ): UserResponse
}

data class UserResponse(
    val id: UUID,
    val firstname: String,
    val lastname: String,
    val createdAt: Instant,
    val status: String,
)

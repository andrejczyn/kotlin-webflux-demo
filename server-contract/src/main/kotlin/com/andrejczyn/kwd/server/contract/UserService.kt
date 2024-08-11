package com.andrejczyn.kwd.server.contract

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

interface UserService {
    @GetMapping("/users/{userId}")
    suspend fun user(
        @PathVariable userId: UUID,
        time: Long = 1000,
    ): UserResponse
}

data class UserResponse(val status: String)

package com.andrejczyn.kwd.server.contract

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.GetExchange
import java.util.UUID

interface UserService {
    @GetExchange("/users/{userId}")
    suspend fun user(
        @PathVariable userId: UUID,
    ): UserResponse
}

data class UserResponse(val id: UUID, val status: String)

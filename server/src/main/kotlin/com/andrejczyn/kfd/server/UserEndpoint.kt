package com.andrejczyn.kfd.server

import com.andrejczyn.kwd.server.contract.UserResponse
import com.andrejczyn.kwd.server.contract.UserService
import kotlinx.coroutines.delay
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.UUID

@RestController
class UserEndpoint : UserService {
    override suspend fun user(
        @PathVariable userId: UUID,
        waitTime: Long,
    ): UserResponse {
        delay(waitTime)
        return UserResponse(
            id = userId,
            firstname = "John",
            lastname = "Kowalski",
            status = "ACTIVE",
            createdAt = Instant.now(),
        )
    }
}

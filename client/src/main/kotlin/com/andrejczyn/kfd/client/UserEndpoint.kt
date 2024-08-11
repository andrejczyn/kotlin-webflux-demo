package com.andrejczyn.kfd.client

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.UUID

@RestController
@RequestMapping(path = ["/users"])
class UserEndpoint : UserService {
    @GetMapping("/{userId}")
    override suspend fun user(
        @PathVariable userId: UUID,
    ): User {
        return User(
            id = userId,
            firstname = "John",
            surname = "Kowalski",
            createdAt = Instant.now(),
        )
    }
}

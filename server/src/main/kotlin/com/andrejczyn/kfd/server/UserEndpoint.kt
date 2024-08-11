package com.andrejczyn.kfd.server

import com.andrejczyn.kwd.server.contract.UserResponse
import com.andrejczyn.kwd.server.contract.UserService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class UserEndpoint : UserService {
    override suspend fun user(
        @PathVariable userId: UUID,
    ): UserResponse {
        return UserResponse(id = userId, status = "ACTIVE")
    }
}

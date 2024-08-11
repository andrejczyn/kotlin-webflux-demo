package com.andrejczyn.kfd.server

import com.andrejczyn.kwd.server.contract.UserResponse
import com.andrejczyn.kwd.server.contract.UserService
import kotlinx.coroutines.delay
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/server/users")
class UserEndpoint : UserService {
    @GetMapping("/users/{userId}")
    override suspend fun user(
        @PathVariable userId: UUID,
        time: Long,
    ): UserResponse {
        delay(time)
        return UserResponse(status = "OK")
    }
}

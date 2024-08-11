package com.andrejczyn.kfd.client

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.delay
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import java.time.Instant
import java.util.UUID

@RestController
@RequestMapping(path = ["/users"])
class UserEndpoint(val userClient: UserClient) : UserService {
    val logger = KotlinLogging.logger { }

    @GetMapping("/{userId}")
    override suspend fun user(
        userId: UUID,
        waitTime: Long,
    ): UserClientResponse {
        delay(waitTime)
        return UserClientResponse(
            id = UUID.randomUUID(),
            firstname = "ddd",
            surname = "ddd",
            displayName = "dddd",
            createdAt = Instant.now(),
        )
//        return userClient.user(userId, waitTime)
    }
}

@Service
class UserClient(builder: WebClient.Builder) {
    private var service =
        HttpServiceProxyFactory.builderFor(
            WebClientAdapter.create(
                builder.baseUrl("http://127.0.0.1:8081").build(),
            ),
        ).build()
            .createClient(com.andrejczyn.kwd.server.contract.UserService::class.java)

    suspend fun user(
        userId: UUID,
        waitTime: Long,
    ): UserClientResponse {
        val response =
            service.user(userId, waitTime)

        return UserClientResponse(
            id = response.id,
            firstname = response.firstname,
            surname = response.lastname,
            displayName = "${response.firstname} ${response.lastname}",
            createdAt = Instant.now(),
        )
    }
}

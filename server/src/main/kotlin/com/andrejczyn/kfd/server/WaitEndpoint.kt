package com.andrejczyn.kfd.server

import kotlinx.coroutines.delay
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WaitEndpoint {
    @GetMapping("/wait")
    suspend fun wait(time: Long = 1000): Any {
        delay(time)
        return Result(status = "OK")
    }
}

data class Result(val status: String)

package com.andrejczyn.kfd.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import reactor.netty.resources.ConnectionProvider

@SpringBootApplication
class ClientApplication

fun main(args: Array<String>) {
    runApplication<ClientApplication>(*args)
}

@Configuration
class ClientConfiguration {
    @Bean
    fun webClientBuilder(): WebClient.Builder {
        val httpClient =
            HttpClient.create(
                ConnectionProvider.create("test", 5000),
            )

        return WebClient.builder()
            .clientConnector(ReactorClientHttpConnector(httpClient))
    }
}

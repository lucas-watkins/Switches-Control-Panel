package com.lucaspowered.switches_cpanel

import io.kvision.remote.getAllServiceManagers
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication(
    exclude = [
        org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration::class,
        org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration::class
    ]
)
class KVApplication {
    @Bean
    fun getManagers() = getAllServiceManagers()
}

fun main(args: Array<String>) {
    runApplication<KVApplication>(*args)
}

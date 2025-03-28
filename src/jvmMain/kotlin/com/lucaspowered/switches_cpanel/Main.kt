package com.lucaspowered.switches_cpanel

import io.kvision.remote.getAllServiceManagers
import kotlinx.serialization.SerializationException
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import kotlinx.serialization.json.Json
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.system.exitProcess

@SpringBootApplication(
    exclude = [
        org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration::class,
        org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration::class
    ]
)
class KVApplication {
    @Bean
    fun getManagers() = getAllServiceManagers()

    companion object {
        var configHasErrors = false
    }
}

fun main(args: Array<String>) {
    // Check integrity of config
    runApplication<KVApplication>(*args)
    try {
        Json.decodeFromString<List<SwitchInfo>>(Files.readString(Path("switches.json")))
    } catch (e: SerializationException) {
        System.err.println("Serialization Error. Please check your config file to add switches")
        System.err.println(e.message)
        KVApplication.configHasErrors = true
    }
}

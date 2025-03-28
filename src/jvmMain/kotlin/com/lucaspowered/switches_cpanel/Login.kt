package com.lucaspowered.switches_cpanel

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import kotlinx.serialization.json.Json
import java.nio.file.Files
import kotlin.io.path.Path

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class LoginService : ILoginService {
    private val login by lazy {Json.decodeFromString<Login>(Files.readString(Path("login.json")))}

    override suspend fun getUsername() = login.username
    override suspend fun getPassword() = login.password
    override suspend fun configHasErrors() = KVApplication.configHasErrors
}
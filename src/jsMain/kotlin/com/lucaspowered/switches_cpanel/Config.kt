package com.lucaspowered.switches_cpanel

import io.kvision.remote.getService

object Config {
    private val loginService = getService<ILoginService>()

    suspend fun getUsername() = loginService.getUsername()
    suspend fun getPassword() = loginService.getPassword()
    suspend fun configHasErrors() = loginService.configHasErrors()
}
package com.lucaspowered.switches_cpanel

import kotlinx.serialization.Serializable

@Serializable
data class Login(val username: String, val password: String)
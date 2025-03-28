package com.lucaspowered.switches_cpanel

import kotlinx.serialization.Serializable

@Serializable
data class SwitchInfo(val id: Int, val name: String, val url: String, val description: String)

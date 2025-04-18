package com.lucaspowered.switches_cpanel

import io.kvision.annotations.KVService

@KVService
interface IRequestsService {
    suspend fun httpGet(url: String): String
}
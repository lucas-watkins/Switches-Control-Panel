package com.lucaspowered.switches_cpanel

import io.kvision.annotations.KVService

@KVService
interface ISwitchService {

    /* Gets url or returns "undefined" */
    suspend fun getName(id: Int): String

    /* Gets url or returns "undefined" */
    suspend fun getUrl(id: Int): String

    /* Gets url or returns "undefined" */
    suspend fun getDesc(id: Int): String
}
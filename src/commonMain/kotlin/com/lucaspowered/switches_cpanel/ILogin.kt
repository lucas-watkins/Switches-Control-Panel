package com.lucaspowered.switches_cpanel

import io.kvision.annotations.KVService

@KVService
interface ILoginService {
   suspend fun getUsername(): String
   suspend fun getPassword(): String
}
package com.lucaspowered.switches_cpanel

import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import java.io.IOException
import java.time.Duration

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class RequestsService : IRequestsService {

    private val client = OkHttpClient.Builder().connectTimeout(Duration.ofSeconds(5)).build()

    override suspend fun httpGet(url: String): String {
        try {
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            return response.body.toString()
        } catch (e: IOException) {
            return "not reached"
        }
    }
}
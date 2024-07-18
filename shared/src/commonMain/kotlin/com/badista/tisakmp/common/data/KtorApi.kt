package com.badista.tisakmp.common.data

import com.badista.tisakmp.common.util.initLogger
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

private const val BASE_URL = "https://tisa-api.topindoku.co.id/api/v1/"

internal abstract class KtorApi {

    val client = HttpClient {
        install(Logging) {
            level = LogLevel.HEADERS
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.d(tag = "KtorResponse", message = message)
                }
            }
        }.also { initLogger() }

        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    explicitNulls = true
                    ignoreUnknownKeys = true
                    useAlternativeNames = true
                    followRedirects = true
                    serializersModule
                }
            )
        }
    }

    fun HttpRequestBuilder.endPoint(path: String) {
        url {
            takeFrom(BASE_URL)
            path(path)
            contentType(ContentType.Application.Json)
        }
    }
}
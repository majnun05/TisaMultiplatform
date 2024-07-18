package com.badista.tisakmp.auth.data

import com.badista.tisakmp.common.data.KtorApi
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

internal class AuthService: KtorApi() {

    suspend fun login(request: SignInRequest): LoginResponse = client.post {
        endPoint(path = "api/v1/auth")
        setBody(request)
    }.body()

//    suspend fun getProfile()
}

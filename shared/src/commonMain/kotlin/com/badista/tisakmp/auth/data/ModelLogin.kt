package com.badista.tisakmp.auth.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonObject

@kotlinx.serialization.Serializable
internal data class SignUpRequest(
    @SerialName("name") val name: String,
    @SerialName("email") val email: String,
    @SerialName("password") val password: String
)

@kotlinx.serialization.Serializable
internal data class SignInRequest(
    @SerialName("username") val username: String,
    @SerialName("password") val password: String
)

@kotlinx.serialization.Serializable
internal data class LoginResponse(
    @SerialName("code") val code: Int? = 0,
    @SerialName("status") val status: String? = null,
    @SerialName("data") val data: LoginResponseData? = null,
    @SerialName("errors") val errors: JsonObject? = null
)

@kotlinx.serialization.Serializable
internal data class LoginResponseData(
    @SerialName("access_token") val access_token: String,
    @SerialName("refresh_token") val refresh_token: String,
    @SerialName("expired_at") val expired_at: Long
)

// {"code":400,"status":"BAD_REQUEST","data":null,"errors":{"general":"USERNAME_OR_PASSWORD_INVALID"}}
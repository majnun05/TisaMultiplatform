package com.badista.tisakmp.auth.domain.model

data class LoginData(
    val access_token: String,
    val refresh_token: String,
    val expired_at: Long
)

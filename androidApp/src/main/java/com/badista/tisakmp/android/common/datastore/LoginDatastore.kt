package com.badista.tisakmp.android.common.datastore

import com.badista.tisakmp.auth.domain.model.LoginData
import kotlinx.serialization.Serializable

@Serializable
data class LoginDatastore(
//    kalo id dari -> -1
    val access_token: String = "",
    val refresh_token: String = "",
    val expired_at: Long = 0
)

fun LoginDatastore.toLoginData(): LoginData {
    return LoginData(access_token, refresh_token, expired_at)
}

fun LoginData.toLoginDatastore(): LoginDatastore {
    return LoginDatastore(access_token, refresh_token, expired_at)
}
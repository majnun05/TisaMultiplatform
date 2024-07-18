package com.badista.tisakmp.auth.data

import com.badista.tisakmp.auth.domain.model.LoginData

internal fun LoginResponseData.toLoginData(): LoginData {
    return LoginData(
        access_token, refresh_token, expired_at
    )
}
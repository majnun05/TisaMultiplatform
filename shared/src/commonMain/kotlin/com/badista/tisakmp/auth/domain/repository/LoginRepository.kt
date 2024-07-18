package com.badista.tisakmp.auth.domain.repository

import com.badista.tisakmp.auth.domain.model.LoginData
import com.badista.tisakmp.common.util.Result

internal interface LoginRepository {

    suspend fun signIn(
        username: String,
        password: String
    ): Result<LoginData>

}
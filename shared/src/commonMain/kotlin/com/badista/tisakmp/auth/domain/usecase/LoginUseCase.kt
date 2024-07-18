package com.badista.tisakmp.auth.domain.usecase

import com.badista.tisakmp.auth.domain.model.LoginData
import com.badista.tisakmp.auth.domain.repository.LoginRepository
import com.badista.tisakmp.common.util.Result
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginUseCase: KoinComponent {
    private val repository: LoginRepository by inject()

    suspend operator fun invoke(
        username: String,
        password: String
    ): Result<LoginData> {
        if (username.isBlank()) {
            return Result.Error(
                message = "ID / No. Handphone tidak boleh kosong"
            )
        }

        if (password.isBlank()) {
            return Result.Error(
                message = "Password tidak boleh kosong"
            )
        }

        return repository.signIn(username, password)
    }
}
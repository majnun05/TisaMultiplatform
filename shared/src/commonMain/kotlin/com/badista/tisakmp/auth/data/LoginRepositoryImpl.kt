package com.badista.tisakmp.auth.data

import com.badista.tisakmp.any.json
import com.badista.tisakmp.auth.domain.model.LoginData
import com.badista.tisakmp.auth.domain.repository.LoginRepository
import com.badista.tisakmp.common.util.DispatcherProvider
import com.badista.tisakmp.common.util.Result
import io.github.aakira.napier.Napier
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


internal class LoginRepositoryImpl(
    private val dispatcher: DispatcherProvider,
    private val authService: AuthService
): LoginRepository {
    override suspend fun signIn(username: String, password: String): Result<LoginData> {
        return withContext(dispatcher.io) {
            try {
                val request = SignInRequest(username, password)

                Napier.e(tag = "LoginRepositoryImpl", message = "username: $username")
                Napier.e(tag = "LoginRepositoryImpl", message = "password: $password")

                val authResponse = authService.login(request)

                Napier.e(tag = "LoginRepositoryImpl", message = "authResponse: $authResponse")

                if (authResponse.code == 200){
                    Result.Success(
                        data = authResponse.data!!.toLoginData()
                    )
                } else {
                    Napier.e(tag = "LoginRepositoryImpl", message = "message error json: ${json.encodeToString(authResponse.errors)}")
                    Result.Error(
                        message = json.encodeToString(authResponse.errors)
                    )
                }
//                if (authResponse.code == 400){
//                    Result.Error(
//                        message = "Username or Password Invalid"
//                    )
//                } else {
//                    Result.Error(
//
//                    )
//                }
            } catch (e: Exception) {
                Napier.e(tag = "LoginRepositoryImpl", message = "Exception: $e")
                Result.Error(
                    message = "Oops, we could not send your request, try later! : $e"
                )
            }
        }
    }
}

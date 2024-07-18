package com.badista.tisakmp.android.ui.auth.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.badista.tisakmp.android.common.datastore.LoginDatastore
import com.badista.tisakmp.android.common.datastore.toLoginDatastore
import com.badista.tisakmp.auth.domain.usecase.LoginUseCase
import com.badista.tisakmp.common.util.Result
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val datastore: DataStore<LoginDatastore>
): ViewModel() {
    var uiState by mutableStateOf(LoginUiState())
        private set

    fun signIn() {
        viewModelScope.launch {
            uiState = uiState.copy(isAuthenticating = true)

            val loginResultData = loginUseCase(uiState.username, uiState.password)

            uiState = when (loginResultData){
                is Result.Error -> {
                    Log.e("LOGIN_VIEW_MODEL", "data: ${loginResultData.data}")
                    Log.e("LOGIN_VIEW_MODEL", "message: ${loginResultData.message}")
                    uiState.copy(
                        isAuthenticating = false,
                        authErrorMessage = loginResultData.message
                    )
                }
                is Result.Success -> {
                    datastore.updateData {
                        loginResultData.data!!.toLoginDatastore()
                    }
                    uiState.copy(
                        isAuthenticating = false,
                        authenticationSucceed = true
                    )
                }
            }
        }
    }

    fun updateUsername(input: String){
        uiState = uiState.copy(username = input)
    }

    fun updatePassword(input: String){
        uiState = uiState.copy(password = input)
    }
}

data class LoginUiState(
    var username: String = "",
    var password: String = "",
    var isAuthenticating: Boolean = false,
    var authErrorMessage: Any? = null,
    var authenticationSucceed: Boolean = false
)
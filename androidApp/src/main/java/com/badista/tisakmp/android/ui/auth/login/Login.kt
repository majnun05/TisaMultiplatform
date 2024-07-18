package com.badista.tisakmp.android.ui.auth.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.badista.tisakmp.android.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun Login(
    navController: NavHostController
) {
    val viewModel: LoginViewModel = koinViewModel()
    LoginScreen(
        uiState = viewModel.uiState,
        onEmailChange = viewModel::updateUsername,
        onPasswordChange = viewModel::updatePassword,
        onNavigateToSignUp = {
            navController.navigate(Screen.SignUp.route)
        },
        onNavigateToHome = {
            navController.popBackStack()
            navController.navigate(Screen.Home.route)
        },
        onSignInClick = viewModel::signIn
    )
}
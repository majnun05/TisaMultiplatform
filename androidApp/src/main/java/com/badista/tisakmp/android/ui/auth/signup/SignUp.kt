package com.badista.tisakmp.android.ui.auth.signup

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.badista.tisakmp.android.navigation.Screen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUp(
    navController: NavHostController
) {
    val viewModel: SignUpViewModel = koinViewModel()
    SignUpScreen(
        uiState = viewModel.uiState,
        onUsernameChange = viewModel::updateUsername,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onNavigateToLogin = {
            navController.getBackStackEntry(Screen.SignIn.route)
            navController.navigate(Screen.SignIn.route)
        },
        onNavigateToHome = {
            navController.navigate(Screen.Home.route)
            navController.popBackStack()
        },
//        onSignUpClick = viewModel::signUp
    )
}
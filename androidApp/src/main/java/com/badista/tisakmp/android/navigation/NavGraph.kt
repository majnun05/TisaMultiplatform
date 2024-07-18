package com.badista.tisakmp.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.badista.tisakmp.android.ui.auth.login.Login
import com.badista.tisakmp.android.ui.auth.signup.SignUp
import com.badista.tisakmp.android.ui.bottom_navigation.HomeNavigationScreen
import com.badista.tisakmp.android.ui.splash.view.AnimatedSplashScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    accessToken: String?
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // splash
        composable(route = Screen.Splash.route) {
            AnimatedSplashScreen(navController = navController)
        }

        // home navigation
        composable(route = Screen.Home.route) {
            HomeNavigationScreen()
        }

        // sign in
        composable(route = Screen.SignIn.route) {
            Login(navController = navController)
        }

        // sign up
        composable(route = Screen.SignUp.route) {
            SignUp(navController = navController)
        }
    }

    LaunchedEffect(key1 = accessToken, block = {
        if (accessToken != null && accessToken.isEmpty()){
            navController.popBackStack()
            navController.navigate(Screen.SignIn.route)
        }
    })
}
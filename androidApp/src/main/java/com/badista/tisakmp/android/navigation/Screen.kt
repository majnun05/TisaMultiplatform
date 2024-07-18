package com.badista.tisakmp.android.navigation

sealed class Screen(val route: String) {
    data object Splash: Screen("splash_screen")
    data object SignIn: Screen("login_screeen")
    data object SignUp: Screen("signup_screen")
    data object Home: Screen("home_screeen")
    data object Visits: Screen("visits_screeen")
    data object Partners: Screen("partners_screeen")
    data object Profile: Screen("profile_screeen")
}
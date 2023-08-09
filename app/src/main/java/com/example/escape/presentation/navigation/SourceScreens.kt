package com.example.escape.presentation.navigation

sealed class SourceScreens(val route: String){
    object WelcomeSplash: SourceScreens(route = "welcome_splash_screen")
    object MainScreen: SourceScreens(route = "main_screen")
    object LoadingSplash: SourceScreens(route = "loading_splash_screen")
    object WelcomeScreen: SourceScreens(route = "welcome_screen")
    object IntroduceScreen: SourceScreens(route = "introduce_screen")
}



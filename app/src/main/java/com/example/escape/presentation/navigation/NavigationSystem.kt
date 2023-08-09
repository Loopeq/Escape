package com.example.escape.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.escape.presentation.levels.introduce_game_level.IntroduceScreen
import com.example.escape.presentation.levels.welcome_game_level.WelcomeScreen

@Composable
fun NavigationSystem(provideNavHostController: () -> NavHostController, provideStartDestination: () -> String){
    NavHost(navController = provideNavHostController(), startDestination = provideStartDestination()) {
        composable(SourceScreens.WelcomeScreen.route) {
            WelcomeScreen{
                provideNavHostController().navigate(SourceScreens.IntroduceScreen.route)
            }
        }

        composable(SourceScreens.IntroduceScreen.route){
            IntroduceScreen()
        }
    }
}


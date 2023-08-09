package com.example.escape.presentation.source.welcome_splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeSplashScreenViewModel @Inject constructor(): ViewModel() {

    var startAnimation by mutableStateOf(false)

    internal fun onAnimationEnd(){
        startAnimation = true
    }
}
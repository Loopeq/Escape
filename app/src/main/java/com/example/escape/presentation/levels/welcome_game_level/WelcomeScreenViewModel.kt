package com.example.escape.presentation.levels.welcome_game_level

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel @Inject constructor(): ViewModel() {
    init {
        Log.d("logi", "viewmodel")
    }
}
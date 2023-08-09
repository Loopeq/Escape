package com.example.escape.presentation.levels.welcome_game_level

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.escape.presentation.navigation.NavigationSystemViewModel

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, onComplete: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome screen")
        Button(onClick = onComplete) {
            Text(text = "Next")
        }
    }
}


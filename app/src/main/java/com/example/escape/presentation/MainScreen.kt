package com.example.escape.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.escape.presentation.navigation.NavigationSystem
import com.example.escape.presentation.navigation.SourceScreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navHostController = rememberNavController()
    Scaffold(topBar = { TopGameAppBar(textTitle = "Уровень 1") }) {
        NavigationSystem(provideNavHostController = { navHostController }, provideStartDestination = {SourceScreens.WelcomeScreen.route})
    }
}


@Composable
fun TopGameAppBar(modifier: Modifier = Modifier, textTitle: String) {
    TopAppBar(contentColor = MaterialTheme.colors.primary) {
        Text(
            textTitle,
            style = MaterialTheme.typography.h1.copy(fontSize = 20.sp),
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}
package com.example.escape.presentation.source.welcome_splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.escape.R
import com.example.escape.presentation.ui.theme.EscapeTheme
import kotlinx.coroutines.delay


@Composable
fun WelcomeSplashScreen(welcomeSplashScreenViewModel: WelcomeSplashScreenViewModel = hiltViewModel(),
                        navigateToSelectLanguageScreen: () -> Unit){
    val startAnimation = welcomeSplashScreenViewModel.startAnimation
    val alphaAnim = animateFloatAsState(targetValue =
        if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 4000
        )
    )
    LaunchedEffect(key1 = true){
        welcomeSplashScreenViewModel.onAnimationEnd()
        delay(4000)
        navigateToSelectLanguageScreen()
    }
    WelcomeSplashScreenContent(alpha = alphaAnim.value)
}

@Composable
fun WelcomeSplashScreenContent(modifier: Modifier = Modifier, alpha: Float) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .alpha(alpha = alpha),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.exclude),
                contentDescription = null, modifier = Modifier
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.h1.copy(fontSize = 45.sp),
            )
        }
        Text(
            text = stringResource(id = R.string.kudos),
            style = MaterialTheme.typography.h1.copy(fontSize = 14.sp),
            modifier = Modifier.padding(bottom = 15.dp)
        )

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WelcomeSplashScreenPrev() {
    EscapeTheme() {
        WelcomeSplashScreenContent(alpha = 1f)
    }
}
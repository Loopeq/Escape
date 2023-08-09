package com.example.escape.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.escape.R


val RobotoMono = FontFamily(
    Font(R.font.roboto_mono_regular, FontWeight.Normal),

)

val Typography = Typography(
    defaultFontFamily = RobotoMono,

    h1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        color = Color.White
    )

)
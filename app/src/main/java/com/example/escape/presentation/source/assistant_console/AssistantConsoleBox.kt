package com.example.escape.presentation.source.assistant_console

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.escape.R
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay

@Composable
fun AssistantConsoleBox(
    textList: List<String>, delay: Long, onTextDone: () -> Unit,
) {
    var textValue by remember { mutableStateOf("") }
    var listIndex by remember { mutableStateOf(0) }
    var stopTextAnimation by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = listIndex) {
        textValue = ""
        for (chr in textList[listIndex]) {
            if (stopTextAnimation) {
                textValue = textList[listIndex]
                break
            }
            textValue += chr
            delay(delay)
        }
        if(textValue == textList[textList.size - 1]){
            onTextDone()
        }
        return@LaunchedEffect
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 15.dp,
                end = 15.dp,
                top = 15.dp
            )
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .clickable {
                    if (textList[listIndex] == textValue) {
                        stopTextAnimation = false
                        if(textList.size - 1 != listIndex){
                            listIndex += 1
                        }
                    } else {
                        stopTextAnimation = true
                    }
                }
        ) {
            Text(
                text = stringResource(id = R.string.assistant),
                color = MaterialTheme.colors.onSecondary,
                style = MaterialTheme.typography.h1.copy(fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = textValue, color = MaterialTheme.colors.secondaryVariant, modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(start = 12.dp, end = 12.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.h1.copy(fontSize = 15.sp),
                textAlign = TextAlign.Start
            )
        }

    }
}
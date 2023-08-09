package com.example.escape.presentation.levels.pilot_level

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.escape.R
import com.example.escape.presentation.source.assistant_console.AssistantConsoleBox
import com.example.escape.presentation.ui.theme.EscapeTheme

@Composable
fun PilotLevel(
    modifier: Modifier = Modifier,
    topPaddingValues: PaddingValues,
    enterBlockState: EnterBlockState,
    onEvent: (PilotLevelEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        AssistantConsoleBox(
            textList = listOf(
                stringResource(R.string.pilotLevelConsole1),
                stringResource(id = R.string.pilotLevelConsole2),
                stringResource(id = R.string.pilotLevelConsole3)
            ),
            delay = 50,
        ) {
            onEvent(PilotLevelEvent.ShowEnterBlock)
        }
        Spacer(modifier = Modifier.height(10.dp))
        EnterNameTextField(
            provideTextFieldValue = { enterBlockState.textFieldValue },
            onValueChange = { onEvent(PilotLevelEvent.EditTextFieldValue(it)) }
        )
        Spacer(modifier = Modifier.height(10.dp))
//        Button(
//            onClick = {
//                onEvent(PilotLevelEvent.EnterPassword(provideTextFieldValue()))
//            },
//            colors = ButtonDefaults.buttonColors(
//                backgroundColor = Color.Black,
//                contentColor = MaterialTheme.colors.secondaryVariant,
//                disabledBackgroundColor = MaterialTheme.colors.primary,
//                disabledContentColor = MaterialTheme.colors.secondaryVariant.copy(alpha = 0.7f)
//            ),
//            modifier = Modifier
//                .align(Alignment.End)
//                .padding(end = 15.dp)
//        ) {
//            Text(text = stringResource(id = R.string.login))
//        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PilotLevelPrev() {
    EscapeTheme {
        //PilotLevel(topPaddingValues = PaddingValues(10.dp))
    }
}



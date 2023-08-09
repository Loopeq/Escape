package com.example.escape.presentation.levels.pilot_level

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.escape.R

@Composable
fun EnterNameTextField(
    provideTextFieldValue: () -> String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = provideTextFieldValue(),
        onValueChange = onValueChange,
        placeholder = {
                          Text(text = stringResource(id = R.string.password), modifier = Modifier.alpha(0.7f))
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.secondaryVariant,
            cursorColor = MaterialTheme.colors.secondaryVariant,
            backgroundColor = MaterialTheme.colors.secondary,
            placeholderColor = MaterialTheme.colors.secondaryVariant,
        ),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    )
}
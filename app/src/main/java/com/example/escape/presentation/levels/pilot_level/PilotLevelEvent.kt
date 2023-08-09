package com.example.escape.presentation.levels.pilot_level

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.res.stringResource
import com.example.escape.R

sealed class PilotLevelEvent{
    object ShowEnterBlock: PilotLevelEvent()
    data class EnterPassword(val password: String): PilotLevelEvent()
    data class FocusChange(val focusState: FocusState): PilotLevelEvent()
    data class EditTextFieldValue(val text: String): PilotLevelEvent()
}


data class EnterBlockState(
    val isShow: Boolean = false,
    val textFieldValue: String = "",
    val isHintShow: Boolean = true,
    val isTextFieldError: Boolean = false,
){
    val isEnterButtonEnable: Boolean = textFieldValue.isNotEmpty()
}


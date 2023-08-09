package com.example.escape.presentation.levels.pilot_level

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@HiltViewModel
class PilotLevelViewModel @Inject constructor(): ViewModel() {

    private var _uiEventsFlow = MutableSharedFlow<UiEvents>()
    val uiEventsFlow = _uiEventsFlow.asSharedFlow()

    private var _enterBlockState = mutableStateOf(EnterBlockState())
    var enterBlockState: State<EnterBlockState> = _enterBlockState


    internal fun onEvent(event: PilotLevelEvent){
        when(event){
            is PilotLevelEvent.ShowEnterBlock -> {
                _enterBlockState.value = enterBlockState.value.copy(
                    isShow = true
                )
            }
            is PilotLevelEvent.EditTextFieldValue -> {
                _enterBlockState.value = enterBlockState.value.copy(
                    textFieldValue = event.text
                )
            }
            is PilotLevelEvent.FocusChange -> {
                _enterBlockState.value = enterBlockState.value.copy(
                    isHintShow = !event.focusState.isFocused
                )
            }
            is PilotLevelEvent.EnterPassword -> {
                var textFieldState: Boolean = false
                if(event.password.length < 10) textFieldState = true
                _enterBlockState.value = enterBlockState.value.copy(
                    isTextFieldError = textFieldState
                )
            }

        }
    }

    sealed class UiEvents{
        data class ShowSnackBar(val text: String): UiEvents()
    }

}




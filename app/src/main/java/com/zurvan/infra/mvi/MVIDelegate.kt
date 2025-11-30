package com.zurvan.infra.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MVIDelegate<UiState, UiAction, UiEffect>(
    initialUiState: UiState,
) : MVI<UiState, UiAction, UiEffect> {

    private val _uiState = MutableStateFlow(initialUiState)
    override val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    override val currentUiState: UiState
        get() = uiState.value

    private val _uiEffect by lazy { Channel<UiEffect>() }
    override val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    override fun onAction(uiAction: UiAction) {

    }

    override fun updateUiState(newUiState: UiState) {
        _uiState.update { newUiState }
    }

    override fun updateUiState(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    override fun ViewModel.emitUiEffect(uiEffect: UiEffect) {
        viewModelScope.launch { _uiEffect.send(uiEffect) }
    }
}
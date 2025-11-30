package com.zurvan.infra.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MVI<UiState, UiAction, UiEffect> {
    val uiState: StateFlow<UiState>

    /**
     * Returns the current value of [uiState], just a shortcut for "uiState.value".
     * */
    val currentUiState: UiState

    val uiEffect: Flow<UiEffect>

    fun onAction(uiAction: UiAction)

    fun updateUiState(block: UiState.() -> UiState)

    fun updateUiState(newUiState: UiState)

    fun ViewModel.emitUiEffect(uiEffect: UiEffect)
}

/**
 * A function to create a new instance of [MVI] using delegate.
 * Example:
 * ```
 * class MyViewModel : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(initialState) {
 * ```
 * */
fun <UiState, UiAction, UiEffect> mvi(
    initialState: UiState,
): MVI<UiState, UiAction, UiEffect> = MVIDelegate(initialState)
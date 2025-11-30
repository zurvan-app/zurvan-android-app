package com.zurvan.infra.mvi

import kotlinx.coroutines.flow.StateFlow

interface MVI<UiState, UiAction> {
    val uiState: StateFlow<UiState>

    /**
     * Returns the current value of [uiState], just a shortcut for "uiState.value".
     * */
    val currentUiState: UiState

    fun onAction(uiAction: UiAction)

    fun updateUiState(block: UiState.() -> UiState)

    fun updateUiState(newUiState: UiState)

}

/**
 * A function to create a new instance of [MVI] using delegate.
 * Example:
 * ```
 * class MyViewModel : ViewModel(), MVI<UiState, UiAction> by mvi(initialState) {
 * ```
 * */
fun <UiState, UiAction> mvi(
    initialState: UiState,
): MVI<UiState, UiAction> = MVIDelegate(initialState)
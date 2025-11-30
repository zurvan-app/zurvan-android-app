package com.zurvan.feature.todolist

object TodoListContract {
    data class UIState(
        val isLoading: Boolean,
    ) {
        companion object {
            fun init(): UIState {
                return UIState(
                    isLoading = false
                )
            }
        }
    }

    sealed interface UIAction {
    }
}
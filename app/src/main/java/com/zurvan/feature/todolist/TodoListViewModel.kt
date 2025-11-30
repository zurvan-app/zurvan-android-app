package com.zurvan.feature.todolist

import androidx.lifecycle.ViewModel
import com.zurvan.infra.mvi.MVI
import com.zurvan.infra.mvi.mvi

class TodoListViewModel() : ViewModel(),
    MVI<TodoListContract.UIState, TodoListContract.UIAction> by mvi(TodoListContract.UIState.init()) {

    override fun onAction(uiAction: TodoListContract.UIAction) {

    }
}
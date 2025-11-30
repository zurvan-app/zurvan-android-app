package com.zurvan.feature.todolist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zurvan.infra.ui.theme.AppTheme

@Composable
fun TodoListScreen(
    state: TodoListContract.UIState,
    onAction: (TodoListContract.UIAction) -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier) {
            Text("Todo List")
        }
    }
}

@Preview
@Composable
fun TodoListScreenPreview() {
    AppTheme {
        TodoListScreen(TodoListContract.UIState.init(), {})
    }
}
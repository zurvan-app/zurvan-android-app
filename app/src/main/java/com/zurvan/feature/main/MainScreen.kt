package com.zurvan.feature.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zurvan.feature.todolist.TodoListScreen
import com.zurvan.feature.todolist.TodoListViewModel

private sealed class Dest(val route: String, val label: String, val icon: ImageVector) {
    data object TodoList : Dest("todo-list", "Lists", Icons.AutoMirrored.Filled.List)
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold { padding ->
        NavHost(
            navController = navController,
            startDestination = Dest.TodoList.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Dest.TodoList.route) {
                val viewModel: TodoListViewModel = viewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                TodoListScreen(uiState, viewModel::onAction)
            }
        }
    }
}
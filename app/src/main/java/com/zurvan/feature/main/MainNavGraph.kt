package com.zurvan.feature.main

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.zurvan.feature.todolist.TodoListScreen
import com.zurvan.feature.todolist.TodoListViewModel

fun NavGraphBuilder.mainNavGraph(navController: NavController) {
    composable(MainRoutes.TodoList.route) {
        val viewModel: TodoListViewModel = viewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        TodoListScreen(
            state = uiState,
            onAction = viewModel::onAction
        )
    }
}

package com.zurvan.feature.main

sealed class MainRoutes(val route: String) {
    object TodoList : MainRoutes("todo-list")
}
package com.example.pawbuds.ui.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Swipe : Screen("swipe")
    object ChatList : Screen("chat_list")
    object Profile : Screen("profile")

    object Register : Screen("register")

    object ChatDetail : Screen("chat_detail/{chatId}") {
        fun createRoute(chatId: String) = "chat_detail/$chatId"
    }
}
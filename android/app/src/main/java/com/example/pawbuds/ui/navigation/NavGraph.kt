package com.example.pawbuds.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pawbuds.ui.features.auth.LoginScreen
import com.example.pawbuds.ui.features.auth.RegisterScreen
import com.example.pawbuds.ui.features.profile.ProfileScreen
import com.example.pawbuds.ui.features.swipe.SwipeScreen

@Composable
fun NavGraph(
    startDestination: String = Screen.Login.route
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        Modifier.fillMaxSize()
    ) {
        // Pantalla de Login
        composable(route = Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Swipe.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(Screen.Register.route)
                }
            )
        }

        composable(route = Screen.Register.route) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(Screen.Swipe.route) {
                        popUpTo(Screen.Register.route) { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }

        // Pantalla Swipe
        composable(route = Screen.Swipe.route) {
            SwipeScreen(
                onNavigateToChatList = { navController.navigate(Screen.ChatList.route) },
                onNavigateToProfile = { navController.navigate(Screen.Profile.route) }
            )
        }

        // Pantalla de Chats
        composable(route = Screen.ChatList.route) {
            ChatListScreen(
                onChatClick = { chatId ->
                    navController.navigate(Screen.ChatDetail.createRoute(chatId))
                },
                onNavigateToSwipe = { navController.popBackStack() }
            )
        }

        // Chat individual
        composable(
            route = Screen.ChatDetail.route,
            arguments = listOf(navArgument("chatId") { type = NavType.StringType })
        ) { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("chatId") ?: ""
            ChatDetailScreen(
                chatId = chatId,
                onBackClick = { navController.popBackStack() }
            )
        }

        // Pantalla de perfil
        composable(route = Screen.Profile.route) {
            ProfileScreen(
                onNavigateToSwipe = { navController.navigate(Screen.Swipe.route) },
                onNavigateToChatList = { navController.navigate(Screen.ChatList.route) },
                onNavigateToNotification = { /* TODO: Ir a notificaciones */ },
                onNavigateToSettings = { /* TODO: Ir a ajustes */ },
                onNavigateToInfoDueno = {/* TODO: Ir a la pantalla del dueño */},
                onNavigateToInfoPerro = {/* TODO: Ir a la pantalla del perro */},
                onNavigateToLogin = { navController.navigate(Screen.Login.route) {
                    popUpTo(navController.graph.id) { inclusive = true }
                } }
            )
        }
    }
}


//provisional
@Composable fun ChatListScreen(onChatClick: (String) -> Unit, onNavigateToSwipe: () -> Unit) { /* ... */ }
@Composable fun ChatDetailScreen(chatId: String, onBackClick: () -> Unit) { /* ... */ }
package com.niyaj.socialnetwork.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.niyaj.socialnetwork.presentation.activity.ActivityScreen
import com.niyaj.socialnetwork.presentation.chat.ChatScreen
import com.niyaj.socialnetwork.presentation.login.LoginScreen
import com.niyaj.socialnetwork.presentation.main_feed.MainFeedScreen
import com.niyaj.socialnetwork.presentation.profile.ProfileScreen
import com.niyaj.socialnetwork.presentation.register.RegisterScreen
import com.niyaj.socialnetwork.presentation.splash.SplashScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
    ){
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screen.ChatScreen.route) {
            ChatScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
    }
    
}
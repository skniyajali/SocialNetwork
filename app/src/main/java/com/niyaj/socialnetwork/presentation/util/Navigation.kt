package com.niyaj.socialnetwork.presentation.util

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.niyaj.socialnetwork.domain.models.Post
import com.niyaj.socialnetwork.presentation.PersonListScreen
import com.niyaj.socialnetwork.presentation.activity.ActivityScreen
import com.niyaj.socialnetwork.presentation.chat.ChatScreen
import com.niyaj.socialnetwork.presentation.create_post.CreatePostScreen
import com.niyaj.socialnetwork.presentation.edit_profile.EditProfileScreen
import com.niyaj.socialnetwork.presentation.login.LoginScreen
import com.niyaj.socialnetwork.presentation.main_feed.MainFeedScreen
import com.niyaj.socialnetwork.presentation.post_detail.PostDetailScreen
import com.niyaj.socialnetwork.presentation.profile.ProfileScreen
import com.niyaj.socialnetwork.presentation.register.RegisterScreen
import com.niyaj.socialnetwork.presentation.search.SearchScreen
import com.niyaj.socialnetwork.presentation.splash.SplashScreen

@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
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
        composable(Screen.ChatScreen.route) {
            ChatScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.EditProfileScreen.route) {
            EditProfileScreen(navController = navController)
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(navController = navController)
        }
        composable(Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
        composable(Screen.PostDetailScreen.route) {
            PostDetailScreen(
                navController = navController,
                post = Post(
                    username = "Sk Niyaj Ali",
                    profilePictureUrl = "",
                    description = "Lorem ipsum dolor sit amet, construe sadistic elite, sed\n" +
                            "diam nonhuman usermod temper incident ut labor et door \n" +
                            "magna aliquot erat, sed diam voluptuary",
                    likeCount = 17,
                    commentCount = 7
                )
            )
        }
        composable(Screen.PersonListScreen.route) {
            PersonListScreen(navController = navController)
        }
    }
}
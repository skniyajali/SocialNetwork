package com.niyaj.socialnetwork.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.niyaj.socialnetwork.presentation.components.StandardScaffold
import com.niyaj.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.niyaj.socialnetwork.presentation.util.Navigation
import com.niyaj.socialnetwork.presentation.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialNetworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    StandardScaffold(
                        navController = navController,
                        showBottomBar = navBackStackEntry?.destination?.route in listOf(
                            Screen.MainFeedScreen.route,
                            Screen.ChatScreen.route,
                            Screen.ProfileScreen.route,
                            Screen.ActivityScreen.route,
                            ),
                        modifier = Modifier.fillMaxSize(),
                    ) {

                        Navigation(navController)
                    }
                }
            }
        }
    }
}

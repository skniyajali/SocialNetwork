package com.niyaj.socialnetwork.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Doorbell
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.niyaj.socialnetwork.domain.models.BottomNavItem
import com.niyaj.socialnetwork.presentation.util.Screen

@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.MainFeedScreen.route,
            icon = Icons.Outlined.Home,
            contentDescription = "Home",
        ) ,
        BottomNavItem(
            route = Screen.ChatScreen.route,
            icon = Icons.Outlined.Message,
            contentDescription = "Message",
        ),
        BottomNavItem(
            route = Screen.ActivityScreen.route,
            icon = Icons.Outlined.Doorbell,
            contentDescription = "Activity",
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            icon = Icons.Outlined.Person,
            contentDescription = "Profile",
        )

    ),
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            if(showBottomBar) {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.surface,
                    cutoutShape = CircleShape,
                    elevation = 5.dp,
                ) {
                    BottomNavigation {
                        bottomNavItems.forEachIndexed { _, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                alertCount = bottomNavItem.alertCount,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                            ) {
                                navController.navigate(bottomNavItem.route)
                            }
                        }
                    }
                }
            }
        }
    ) {
        content()
    }
}
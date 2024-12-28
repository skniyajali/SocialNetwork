package com.niyaj.socialnetwork.presentation.main_feed

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.niyaj.socialnetwork.R
import com.niyaj.socialnetwork.domain.models.Post
import com.niyaj.socialnetwork.presentation.components.Post
import com.niyaj.socialnetwork.presentation.components.StandardToolbar
import com.niyaj.socialnetwork.presentation.util.Screen

@Composable
fun MainFeedScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                navController = navController,
                title = {
                    Text(
                        text = stringResource(id = R.string.your_feed),
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onBackground
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                showBackArrow = false,
                navActions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.SearchScreen.route)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            item {
                Post(
                    post = Post(
                        username = "Sk Niyaj Ali",
                        imageUrl = R.drawable.image,
                        profilePictureUrl = "",
                        description = "this is the description of the post you are trying to create and will" +
                                " be displayed in the profile picture when creating the post and updating the profile picture this will be displayed",
                        likeCount = 17,
                        commentCount = 7
                    ),
                    showProfileImage = false,
                    onPostClick = {
                        navController.navigate(Screen.PostDetailScreen.route)
                    }
                )
            }
            item {
                Post(
                    post = Post(
                        username = "New User",
                        imageUrl = R.drawable.kermit,
                        profilePictureUrl = "",
                        description = "this is the description of the post you are trying to create and will" +
                                " be displayed in the profile picture when creating the post and updating the profile picture this will be displayed",
                        likeCount = 17,
                        commentCount = 7
                    ),
                    showProfileImage = false,
                    onPostClick = {
                        navController.navigate(Screen.PostDetailScreen.route)
                    }
                )
            }
        }
    }
}
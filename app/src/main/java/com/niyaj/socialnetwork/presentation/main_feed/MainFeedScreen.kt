package com.niyaj.socialnetwork.presentation.main_feed

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.niyaj.socialnetwork.presentation.components.Post
import com.niyaj.socialnetwork.presentation.components.StandardScaffold

@Composable
fun MainFeedScreen(
    navController: NavController
) {
    Post(post = com.niyaj.socialnetwork.domain.models.Post(
        username = "Sk Niyaj Ali",
        imageUrl = "http://",
        profilePictureUrl = "",
        description = "This is test description for the post you have uploaded to your account and will be displayed in the feed feed when you click on the post link below and click on the link below to see the post description and description for the post description.",
        likeCount = 17,
        commentCount = 7,
    ))
}

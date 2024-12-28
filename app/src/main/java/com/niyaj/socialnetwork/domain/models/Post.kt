package com.niyaj.socialnetwork.domain.models

data class Post(
    val username: String,
    val imageUrl: Int = 0,
    val profilePictureUrl: String,
    val description: String,
    val likeCount: Int,
    val commentCount: Int
)

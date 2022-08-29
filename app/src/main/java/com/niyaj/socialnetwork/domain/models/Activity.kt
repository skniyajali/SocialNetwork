package com.niyaj.socialnetwork.domain.models

import com.niyaj.socialnetwork.domain.util.ActivityAction

data class Activity(
    val username: String,
    val actionType: ActivityAction,
    val formattedTime: String,
)

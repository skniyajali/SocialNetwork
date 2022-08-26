package com.niyaj.socialnetwork.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.niyaj.socialnetwork.R
import com.niyaj.socialnetwork.domain.models.Post
import com.niyaj.socialnetwork.presentation.ui.theme.*
import com.niyaj.socialnetwork.util.Constants.MAX_POST_DESCRIPTION_LINES

@Composable
fun Post(
    post: Post,
    profilePictureSize: Dp = 75.dp,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SpaceMedium)
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .offset(y = profilePictureSize / 2f)
            .clip(MaterialTheme.shapes.medium)
            .background(MediumGray)

        ) {
            Image(painterResource(id = R.drawable.image) , contentDescription = stringResource(R.string.post))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceMedium)
            ) {
                ActionRow(
                    username = "Sk Niyaj Ali",
                    modifier = Modifier.fillMaxWidth(),
                    onLikeClick = {},
                    onShareClick = {},
                    onCommentClick = {}
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                Text(
                    text = buildAnnotatedString{
                        append(post.description)
                        withStyle(SpanStyle(
                            color = HintGray
                        )){
                            append(
                                LocalContext.current.getString(R.string.read_more)
                            )
                        }
                    },
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = MAX_POST_DESCRIPTION_LINES,
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.liked_by_x_people,
                            post.likeCount
                        ),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.h2,
                    )
                    Text(
                        text = stringResource(
                            id = R.string.x_comments,
                            post.commentCount
                        ),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.h2,
                    )
                }
            }

        }
        Image(
            painterResource(id = R.drawable.ic_user),
            contentDescription = stringResource(R.string.profile_image),
            modifier = Modifier
                .size(profilePictureSize)
                .clip(CircleShape)
                .align(Alignment.TopCenter),
        )
    }
}

@Composable
fun EngagementButtons(
    modifier: Modifier = Modifier,
    iconSize: Dp = 30.dp,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onShareClick: () -> Unit = {},
    onCommentClick: () -> Unit = {},
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(modifier = Modifier.size(iconSize), onClick = {onLikeClick(!isLiked)}) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = if (isLiked) Color.Red else TextWhite,
                contentDescription = if(isLiked) {
                        stringResource(R.string.unlike)
                    }else{
                        stringResource(R.string.like)
                    }
            )
        }

        Spacer(modifier = Modifier.width(SpaceMedium))
        IconButton(modifier = Modifier.size(iconSize), onClick = {onCommentClick()}) {
            Icon(
                imageVector = Icons.Filled.Comment,
                contentDescription = stringResource(R.string.comment)
            )
        }

        Spacer(modifier = Modifier.width(SpaceMedium))
        IconButton(modifier = Modifier.size(iconSize), onClick = {onShareClick()}) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(R.string.share)
            )
        }
    }
}

@Composable
fun ActionRow(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLikeClick: (Boolean) -> Unit = {},
    onShareClick: () -> Unit = {},
    onCommentClick: () -> Unit = {},
    onUsernameClick: (String) -> Unit = {},
    username: String,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        ) {
        Text(
            text = username,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary,
            ),
            modifier = Modifier
                .clickable {
                    onUsernameClick(username)
                },
        )
        EngagementButtons(
            isLiked = isLiked,
            onLikeClick = onLikeClick,
            onCommentClick = onCommentClick,
            onShareClick = onShareClick,
        )
    }
}
package com.niyaj.socialnetwork.presentation.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.niyaj.socialnetwork.R
import com.niyaj.socialnetwork.domain.models.User
import com.niyaj.socialnetwork.presentation.components.StandardTextField
import com.niyaj.socialnetwork.presentation.components.StandardToolbar
import com.niyaj.socialnetwork.presentation.components.UserProfileItem
import com.niyaj.socialnetwork.presentation.ui.theme.IconSizeMedium
import com.niyaj.socialnetwork.presentation.ui.theme.IconSizeSmall
import com.niyaj.socialnetwork.presentation.ui.theme.SpaceLarge
import com.niyaj.socialnetwork.presentation.ui.theme.SpaceMedium
import com.niyaj.socialnetwork.presentation.util.states.StandardTextFieldState

@ExperimentalMaterialApi
@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.search_for_users),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceLarge)
        ) {
            StandardTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                text = viewModel.searchState.value.text,
                hint = stringResource(id = R.string.search),
                error = viewModel.searchState.value.error,
                leadingIcon = Icons.Default.Search,
                onValueChange = {
                    viewModel.setSearchState(
                        StandardTextFieldState(text = it)
                    )
                }
            )
            Spacer(modifier = Modifier.height(SpaceLarge))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(10) {
                    UserProfileItem(
                        user = User(
                            profilePictureUrl = "",
                            username = "Sk Niyaj Ali",
                            description = "Lorem ipsum dolor sit amet, construe sadistic elite, sed\n" +
                                    "diam nonhuman usermod temper incident ut labor et door \n" +
                                    "magna aliquot erat, sed diam voluptuary",
                            followerCount = 234,
                            followingCount = 534,
                            postCount = 65
                        ),
                        actionIcon = {
                            Icon(
                                imageVector = Icons.Default.PersonAdd,
                                contentDescription = null,
                                tint = MaterialTheme.colors.onBackground,
                                modifier = Modifier.size(IconSizeMedium)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(SpaceMedium))
                }
            }
        }
    }
}
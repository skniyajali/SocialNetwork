package com.niyaj.socialnetwork.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.niyaj.socialnetwork.R
import com.niyaj.socialnetwork.presentation.components.StandardTextField
import com.niyaj.socialnetwork.presentation.ui.theme.SpaceLarge
import com.niyaj.socialnetwork.presentation.ui.theme.SpaceMedium
import com.niyaj.socialnetwork.presentation.util.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    Box(modifier= Modifier
        .fillMaxSize()
        .padding(
            start = SpaceLarge,
            end = SpaceLarge,
            top = SpaceLarge,
            bottom = 50.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.login),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.usernameText.value,
                onValueChange = {
                    viewModel.setUsernameText(it)
                },
                keyboardType = KeyboardType.Email,
                hint = stringResource(R.string.login_hint),
                error = viewModel.usernameError.value,
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.passwordText.value,
                onValueChange = {
                    viewModel.setPasswordText(it)
                },
                keyboardType = KeyboardType.Password,
                hint = stringResource(R.string.password_hint),
                showPasswordToggle = viewModel.showPasswordToggle.value,
                onPasswordToggleClick = {
                    viewModel.setShowPasswordToggle(it)
                },
                error = viewModel.passwordError.value,
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {
                   navController.navigate(Screen.MainFeedScreen.route)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = stringResource(R.string.login),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.dont_have_an_account_yet))
                append("")
                withStyle(style = SpanStyle(
                    color = MaterialTheme.colors.primary
                )){
                    append(stringResource(R.string.sign_up))
                }
            },
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.navigate(Screen.RegisterScreen.route)
                }
        )


    }
}
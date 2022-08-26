package com.niyaj.socialnetwork.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.niyaj.socialnetwork.R
import com.niyaj.socialnetwork.presentation.util.TestTags
import com.niyaj.socialnetwork.presentation.util.TestTags.STANDARD_TEXT_FIELD


@Composable
fun StandardTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    maxLength: Int = 40,
    error: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    showPasswordToggle: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
    onValueChange: (String) -> Unit
) {
    var isPasswordToggleDisplayed by remember {
        mutableStateOf(keyboardType == KeyboardType.Password)
    }

    Column(modifier = modifier.fillMaxWidth()) {
        val focusManager = LocalFocusManager.current
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    testTag = STANDARD_TEXT_FIELD
                },
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            value = text,
            onValueChange = {
              if(it.length <= maxLength){
                  onValueChange(it)
              }
            },
            isError = error != "",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.Done,
            ),
            placeholder = {
                Text(text = hint, style = MaterialTheme.typography.body1)
            },
            visualTransformation = if(!showPasswordToggle && isPasswordToggleDisplayed){
               PasswordVisualTransformation()
            }else{
                VisualTransformation.None
            },
            trailingIcon = {
               if(isPasswordToggleDisplayed){
                   IconButton(onClick = { onPasswordToggleClick(!showPasswordToggle) }) {
                        Icon(
                            imageVector = if(showPasswordToggle){
                                Icons.Filled.Visibility
                            }else{
                                Icons.Filled.Visibility
                            },
                            tint = Color.White,
                            contentDescription = if(showPasswordToggle){
                                stringResource(R.string.password_visible_content_description)
                            } else {
                                stringResource(R.string.password_hidden_content_description)
                            },
                        )
                   }
               }
            },
        )
        if(error.isNotEmpty()) {
            Text(
                text = error,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
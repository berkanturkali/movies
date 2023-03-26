package com.example.movies.feature.search.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies_compose.feature.search.R

@Composable
fun SearchInput(
    query: String,
    modifier: Modifier = Modifier
) {

    val focusManager = LocalFocusManager.current

    val focusRequester = remember {
        FocusRequester()
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(modifier = modifier
        .padding(8.dp)
        .focusRequester(focusRequester),
        shape = androidx.compose.foundation.shape.CircleShape,
        value = query ?: "",
        onValueChange = {
            // TODO: on value change
        },
        label = {
            Text(
                text = stringResource(id = R.string.search),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = MoviesIcons.SEARCH),
                contentDescription = stringResource(id = R.string.search),
                tint = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
            )
        },
        textStyle = TextStyle(color = MaterialTheme.colorScheme.onPrimary),
        colors =
        TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f),
            focusedIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            AnimatedVisibility(
                enter = scaleIn(),
                exit = scaleOut(),
                visible = query.isNotEmpty() || query.isNotBlank()
            ) {
                Icon(
                    tint = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f),
                    painter = painterResource(id = MoviesIcons.CLEAR),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable {
                            // TODO: trailing icon click action clean up the text
                            focusManager.clearFocus()
                        }
                )
            }
        },
        singleLine = true
    )
}

@Preview
@Composable
fun SearchInputPrev() {
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
        MoviesTheme {
            SearchInput(query = "")
        }
    }
}
package com.example.movies.feature.search.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcon
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies_compose.feature.search.R
import kotlinx.coroutines.flow.distinctUntilChangedBy

@Composable
fun SearchInput(
    query: TextFieldValue,
    focused: Boolean,
    focusRequester: FocusRequester,
    onValueChange: (TextFieldValue) -> Unit,
    onTrailingIconClick: () -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    onSearchButtonClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    if (!focused) {
        keyboardController?.hide()
    }

    OutlinedTextField(
        modifier = modifier.focusRequester(focusRequester),
        shape = androidx.compose.foundation.shape.CircleShape,
        value = query,
        onValueChange = onValueChange,
        interactionSource = remember {
            MutableInteractionSource()
        }.also { interactionSource ->
            LaunchedEffect(key1 = interactionSource) {
                interactionSource.interactions.distinctUntilChangedBy { it is PressInteraction.Release }
                    .collect {
                        onFocusChanged(true)
                    }
            }
        },
        placeholder = {
            AnimatedVisibility(
                visible = !focused,
                enter = expandHorizontally(animationSpec = tween(200)),
                exit = fadeOut(tween(0))
            ) {
                Text(
                    text = stringResource(id = R.string.search),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                keyboardController?.hide()
                onSearchButtonClick(query.text)
            }),
        leadingIcon = {
            Icon(
                painter = painterResource(id = MoviesIcon.SEARCH),
                contentDescription = stringResource(id = R.string.search),
                tint = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
            )
        },
        textStyle = TextStyle(color = MaterialTheme.colorScheme.onPrimary),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.1f),
            focusedIndicatorColor = Color.Transparent,
            cursorColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            AnimatedVisibility(
                enter = scaleIn(),
                exit = scaleOut(),
                visible = query.text.isNotBlank() && focused
            ) {
                IconButton(onClick = {
                    onTrailingIconClick()
                }) {
                    Icon(
                        tint = MaterialTheme.colorScheme.onPrimary,
                        painter = painterResource(id = MoviesIcon.CLEAR),
                        contentDescription = null, modifier = Modifier.size(16.dp)
                    )
                }
            }
        },
        singleLine = true,
    )
}

@Preview
@Composable
fun SearchInputPrev() {
    MoviesTheme {
        SearchInput(
            query = TextFieldValue(text = ""),
            focusRequester = FocusRequester(),
            focused = false,
            onTrailingIconClick = {},
            onValueChange = {},
            onFocusChanged = {},
            onSearchButtonClick = {},
        )
    }
}
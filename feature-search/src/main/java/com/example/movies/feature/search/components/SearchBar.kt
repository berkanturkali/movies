package com.example.movies.feature.search.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies_compose.feature.search.R

@Composable
fun SearchBar(
    query: TextFieldValue,
    focused: Boolean,
    focusRequester: FocusRequester,
    onQueryChanged: (TextFieldValue) -> Unit,
    onTrailingIconClick: () -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    resetTheQuery: () -> Unit,
    onSearchButtonClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {

        SearchInput(
            query = query,
            focused = focused,
            focusRequester = focusRequester,
            modifier = Modifier
                .then(if (focused) Modifier.fillMaxWidth(0.8f) else Modifier.fillMaxWidth())
                .padding(8.dp),
            onValueChange = onQueryChanged,
            onTrailingIconClick = onTrailingIconClick,
            onFocusChanged = {
                onFocusChanged(it)
            },
            onSearchButtonClick = onSearchButtonClick,
        )
        AnimatedVisibility(
            visible = focused,
            enter = slideInHorizontally(
                initialOffsetX = { it / 2 },
                animationSpec = tween(200)
            ), exit = slideOutHorizontally(
                tween(200)
            )
        ) {
            Text(
                modifier = Modifier
                    .clickable {
                        onFocusChanged(false)
                        resetTheQuery()
                    }
                    .padding(8.dp),
                text = stringResource(id = R.string.search_input_cancel_text),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}

@Preview
@Composable
fun SearchBarPrev() {
    MoviesTheme {
        SearchBar(
            onTrailingIconClick = {},
            focusRequester = FocusRequester(),
            onQueryChanged = {},
            query = TextFieldValue(),
            focused = false,
            onFocusChanged = {},
            onSearchButtonClick = {},
            resetTheQuery = {},
        )
    }
}
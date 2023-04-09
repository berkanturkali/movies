package com.example.movies.feature.search.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies_compose.feature.search.R

@Composable
fun SearchBar(focused: Boolean, onFocusChanged: (Boolean) -> Unit, modifier: Modifier = Modifier) {

    var query by rememberSaveable {
        mutableStateOf("")
    }

    val inputFraction by animateFloatAsState(targetValue = if (focused) 0.9f else 1.0f)

    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        SearchInput(
            query = query,
            modifier = Modifier.fillMaxWidth(inputFraction),
            onValueChange = {
                query = it
            },
            onTrailingIconClick = {
                query = ""
            },
            onFocusChanged = onFocusChanged
        )
        TextButton(
            onClick = {
                onFocusChanged(false)
            },
            modifier = Modifier.size(30.dp)
        ) {
            Text(
                text = stringResource(id = R.string.search_input_cancel_text),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}

@Preview
@Composable
fun SearchBarPrev() {
    MoviesTheme {
        SearchBar(focused = false, onFocusChanged = {})
    }
}
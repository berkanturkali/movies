package com.example.movies.feature.search.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun SearchBar(modifier: Modifier = Modifier) {

    val query = rememberSaveable {
        mutableStateOf("")
    }

    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        SearchInput(
            query = query.value,
            modifier = Modifier.fillMaxWidth(0.9f),
            onValueChange = {
                query.value = it
            },
            onTrailingIconClick = {
                query.value = ""
            }
        )
        Icon(
            painter = painterResource(id = MoviesIcons.CATEGORY),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )
    }
}

@Preview
@Composable
fun SearchBarPrev() {
    MoviesTheme {
        SearchBar()
    }
}
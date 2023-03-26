package com.example.movies.feature.search.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Modifier

@Composable
fun SearchBar(modifier: Modifier = Modifier) {

    val query = rememberSaveable {
        mutableStateOf("")
    }

    SearchInput(
        query = query.value,
        modifier = modifier,
        onValueChange = {
            query.value = it
        },
        onTrailingIconClick = {
            query.value = ""
        }
    )
}
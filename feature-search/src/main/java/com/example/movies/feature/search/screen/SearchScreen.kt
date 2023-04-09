package com.example.movies.feature.search.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.examle.movies.core.ui.components.MoviesScaffold
import com.example.movies.feature.search.components.RecentSearchesClearButton
import com.example.movies.feature.search.components.RecentSearchesTitle
import com.example.movies.feature.search.components.SearchBar

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {

    MoviesScaffold(modifier = modifier) {
        SearchScreenContent()
    }
}

@Composable
private fun SearchScreenContent(modifier: Modifier = Modifier) {

    var focused by rememberSaveable {
        mutableStateOf(false)
    }

    Column(modifier = modifier) {
        SearchBar(
            focused = focused,
            onFocusChanged = { isFocused ->
                focused = isFocused
            }
        )

        if (focused) {
            //RecentSearches

        }


    }
}


@Composable
fun RecentSearches(modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier) {

        item {

        }
    }
}





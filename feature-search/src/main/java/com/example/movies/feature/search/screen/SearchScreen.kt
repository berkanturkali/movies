package com.example.movies.feature.search.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.examle.movies.core.ui.components.MoviesScaffold
import com.example.movies.core.model.search.keyword.Keyword
import com.example.movies.core.model.search.recent_search.RecentSearch
import com.example.movies.feature.search.components.KeywordItem
import com.example.movies.feature.search.components.RecentSearchesTitleAndClearButton
import com.example.movies.feature.search.components.SearchBar
import com.example.movies.feature.search.viewmodel.SearchScreenViewModel

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {

    val viewModel = hiltViewModel<SearchScreenViewModel>()

    val query by viewModel.query.collectAsState(initial = null)

    val keywords = viewModel.keywords.collectAsLazyPagingItems()

    val recentSearches by viewModel.recentSearches.observeAsState()

    MoviesScaffold(modifier = modifier) {
        SearchScreenContent(
            query = query,
            keywords = keywords,
            recentSearches = recentSearches ?: emptyList(),
            onTrailingIconClick = {
                viewModel.setQuery("")
            },
            onQueryChanged = viewModel::setQuery,
            onKeywordItemClick = { keyword ->
                viewModel.setQuery(keyword.name!!)
            }
        )
    }
}

@Composable
private fun SearchScreenContent(
    query: String?,
    keywords: LazyPagingItems<Keyword>,
    recentSearches: List<RecentSearch>,
    onTrailingIconClick: () -> Unit,
    onQueryChanged: (String) -> Unit,
    onKeywordItemClick: (Keyword) -> Unit,
    modifier: Modifier = Modifier
) {

    var focused by rememberSaveable {
        mutableStateOf(false)
    }

    Column(modifier = modifier) {
        SearchBar(
            focused = focused,
            onFocusChanged = { isFocused ->
                focused = isFocused
            },
            onTrailingIconClick = onTrailingIconClick,
            onQueryChanged = onQueryChanged,
            query = query
        )

        if (focused) {
            LazyColumn(modifier = modifier) {

                recentSearches(recentSearches = recentSearches)

                keywords(keywords = keywords, onKeywordItemClick = onKeywordItemClick)

            }

        } else {

        }
    }
}

fun LazyListScope.recentSearches(
    recentSearches: List<RecentSearch>
) {
    item {
        RecentSearchesTitleAndClearButton()
    }
    items(recentSearches) { recentSearch ->

    }

}

fun LazyListScope.keywords(
    keywords: LazyPagingItems<Keyword>,
    onKeywordItemClick: (Keyword) -> Unit
) {
    items(keywords) { keyword ->
        keyword?.let {
            KeywordItem(keyword = keyword, onKeywordItemClick = onKeywordItemClick)
        }
    }
}





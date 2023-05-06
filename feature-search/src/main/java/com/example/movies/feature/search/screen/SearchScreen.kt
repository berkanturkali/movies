package com.example.movies.feature.search.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.examle.movies.core.ui.components.MoviesDivider
import com.examle.movies.core.ui.components.MoviesScaffold
import com.example.movies.core.model.search.keyword.Keyword
import com.example.movies.core.model.search.recent_search.RecentSearch
import com.example.movies.feature.search.components.KeywordItem
import com.example.movies.feature.search.components.RecentSearchItem
import com.example.movies.feature.search.components.RecentSearchesTitleAndClearButton
import com.example.movies.feature.search.components.SearchBar
import com.example.movies.feature.search.viewmodel.SearchScreenViewModel

@Composable
fun SearchScreen(
    navigateToSearchCategoriesScreen: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val viewModel = hiltViewModel<SearchScreenViewModel>()

    val searchInputTextFieldValue by viewModel.textFieldValue.collectAsState()

    val keywords = viewModel.keywords.collectAsLazyPagingItems()

    val recentSearches by viewModel.recentSearches.observeAsState()

    var focused by rememberSaveable {
        mutableStateOf(false)
    }

    val focusManager = LocalFocusManager.current

    MoviesScaffold(
        modifier = modifier,
        topBar = {
            SearchBar(
                query = searchInputTextFieldValue,
                focused = focused,
                onQueryChanged = viewModel::setSearchTextFieldValue,
                onTrailingIconClick = {
                    viewModel.setSearchTextFieldValue(TextFieldValue(""))
                },
                onFocusChanged = {
                    focused = it
                },
                onSearchButtonClick = { query ->
                    viewModel.insertRecentSearch(query)
                    navigateToSearchCategoriesScreen(query)
                },
                onCancelButtonClick = {
                    focused = false
                    focusManager.clearFocus()
                }
            )
        }) {
        AnimatedVisibility(
            visible = focused,
            enter = slideInVertically(),
            exit = fadeOut()
        ) {
            SearchScreenContent(
                keywords = keywords,
                recentSearches = recentSearches ?: emptyList(),
                onKeywordItemClick = { keyword ->
                    viewModel.insertRecentSearch(keyword.name!!)
                    navigateToSearchCategoriesScreen(keyword.name!!)
                    focusManager.clearFocus()
                },
                onRecentSearchClearButtonClick = viewModel::clearRecentSearches,
                onRecentSearchItemClick = { recentSearch ->
                    navigateToSearchCategoriesScreen(recentSearch.text)
                },
                onRecentSearchInwardArrowIconClick = { recentSearch ->
                    viewModel.setSearchTextFieldValue(
                        TextFieldValue(
                            recentSearch.text,
                            selection = TextRange(recentSearch.text.lastIndex + 1)
                        )
                    )
                }
            )
        }
    }
}

@Composable
private fun SearchScreenContent(
    keywords: LazyPagingItems<Keyword>,
    recentSearches: List<RecentSearch>,
    onRecentSearchClearButtonClick: () -> Unit,
    onRecentSearchItemClick: (RecentSearch) -> Unit,
    onRecentSearchInwardArrowIconClick: (RecentSearch) -> Unit,
    onKeywordItemClick: (Keyword) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        if (recentSearches.isNotEmpty()) {
            recentSearches(
                recentSearches = recentSearches,
                onRecentSearchClearButtonClick = onRecentSearchClearButtonClick,
                onRecentSearchItemClick = onRecentSearchItemClick,
                onRecentSearchInwardArrowIconClick = onRecentSearchInwardArrowIconClick,
            )

            divider()
        }
        keywords(keywords = keywords, onKeywordItemClick = onKeywordItemClick)
    }
}

fun LazyListScope.recentSearches(
    recentSearches: List<RecentSearch>,
    onRecentSearchItemClick: (RecentSearch) -> Unit,
    onRecentSearchInwardArrowIconClick: (RecentSearch) -> Unit,
    onRecentSearchClearButtonClick: () -> Unit,
) {
    item {
        RecentSearchesTitleAndClearButton(
            onClearButtonClick = onRecentSearchClearButtonClick,
        )
    }
    items(recentSearches) { recentSearch ->
        RecentSearchItem(
            recentSearch = recentSearch,
            onRecentSearchItemClick = onRecentSearchItemClick,
            onRecentSearchInwardArrowIconClick = onRecentSearchInwardArrowIconClick,
        )
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

fun LazyListScope.divider() {
    item {
        MoviesDivider(thickness = 0.5.dp)
    }
}





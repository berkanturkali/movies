package com.example.movies.feature.search.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.example.movies.core.model.search.keyword.Keyword
import com.example.movies.core.model.search.recent_search.RecentSearch
import com.example.movies.feature.search.screen.divider
import com.example.movies.feature.search.screen.keywords
import com.example.movies.feature.search.screen.recentSearches

@Composable
fun SearchView(
    keywords: LazyPagingItems<Keyword>,
    recentSearches: List<RecentSearch>,
    onRecentSearchClearButtonClick: () -> Unit,
    onRecentSearchItemClick: (RecentSearch) -> Unit,
    onRecentSearchInwardArrowIconClick: (RecentSearch) -> Unit,
    onKeywordItemClick: (Keyword) -> Unit,
    modifier: Modifier = Modifier) {

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
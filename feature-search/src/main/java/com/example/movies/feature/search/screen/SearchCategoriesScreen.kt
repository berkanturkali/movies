package com.example.movies.feature.search.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.examle.movies.core.ui.components.MoviesScaffold
import com.examle.movies.core.ui.providers.LocalSearchQuery
import com.example.movies.core.model.search.SearchCategory
import com.example.movies.feature.search.components.SearchCategoriesTopBar
import com.example.movies.feature.search.components.SearchCategoryTabs
import com.example.movies.feature.search.components.SearchView
import com.example.movies.feature.search.viewmodel.SearchCategoriesScreenViewModel
import com.example.movies.feature.search.viewmodel.SearchScreenViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchCategoriesScreen(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<SearchCategoriesScreenViewModel>()

    val searchScreenViewModel = hiltViewModel<SearchScreenViewModel>()

    val keywords = viewModel.keywords.collectAsLazyPagingItems()

    val recentSearches by viewModel.recentSearches.observeAsState()

    val query by viewModel.queryTextFieldValue.collectAsState()

    val focused = viewModel.focused

    val scope = rememberCoroutineScope()

    val focusManager = LocalFocusManager.current

    val categories = SearchCategory.values()
        .toList()

    val setQuery = !focused && viewModel.isSearchQueryChanged

    val pagerState = rememberPagerState(initialPage = 0)

    MoviesScaffold(
        modifier = modifier,
        topBar = {
            SearchCategoriesTopBar(
                onBackButtonClick = onBackButtonClick,
                query = query,
                focused = focused,
                onTrailingIconClick = {
                    viewModel.clearQuery()
                },
                onSearchQueryChanged = { queryTextFieldValue ->
                    viewModel.setSearchTextFieldValue(queryTextFieldValue)
                },
                onSearchButtonClick = {
                    focusManager.clearFocus()
                    val searchQueryChanged = viewModel.checkIfSearchQueryChanged(it)
                    viewModel.isSearchQueryChanged = searchQueryChanged
                    if (searchQueryChanged) {
                        viewModel.lastSearchQuery = it
                        viewModel.setSearchTextFieldValue(TextFieldValue(it))
                        searchScreenViewModel.insertRecentSearch(it)
                    }
                },
                onFocusChanged = {
                    viewModel.focused = it
                },
                resetTheQuery = {
                    viewModel.resetTheQuery()
                }
            )
        }) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                SearchCategoryTabs(
                    modifier = modifier,
                    categories = categories,
                    onCategorySelected = { searchCategoryIndex ->
                        scope.launch { pagerState.animateScrollToPage(searchCategoryIndex) }
                    },
                    selectedIndex = pagerState.currentPage
                )
                HorizontalPager(
                    state = pagerState,
                    pageCount = categories.size,
                    userScrollEnabled = true,
                    beyondBoundsPageCount = 3,
                ) { index ->
                    CompositionLocalProvider(
                        LocalSearchQuery provides query.text,
                    ) {
                        when (index) {
                            0 -> {
                                Companies(setQuery = setQuery)
                            }
                            1 -> {
                                Collections(setQuery = setQuery)
                            }
                            2 -> {
                                Movies(setQuery = setQuery)
                            }
                            3 -> {
                                People(setQuery = setQuery)
                            }
                            4 -> {
                                TvShows(setQuery = setQuery)
                            }
                        }
                    }
                }
            }
        }
        AnimatedVisibility(
            visible = focused,
            enter = fadeIn(),
            exit = fadeOut(tween(200))
        ) {
            SearchView(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface),
                keywords = keywords,
                recentSearches = recentSearches ?: emptyList(),
                onRecentSearchClearButtonClick = {
                    searchScreenViewModel.clearRecentSearches()
                },
                onRecentSearchItemClick = { recentSearch ->
                    focusManager.clearFocus()
                    val searchQueryChanged =
                        viewModel.queryTextFieldValue.value.text != recentSearch.text
                    viewModel.isSearchQueryChanged = searchQueryChanged
                    if (searchQueryChanged) {
                        viewModel.setSearchTextFieldValue(TextFieldValue(recentSearch.text))
                    }
                },
                onRecentSearchInwardArrowIconClick = { recentSearch ->
                    viewModel.setSearchTextFieldValue(
                        TextFieldValue(
                            recentSearch.text,
                            selection = TextRange(recentSearch.text.lastIndex + 1)
                        )
                    )
                },
                onKeywordItemClick = { keyword ->
                    keyword.name?.let { name ->
                        focusManager.clearFocus()
                        viewModel.isSearchQueryChanged = true
                        viewModel.lastSearchQuery = name
                        viewModel.setSearchTextFieldValue(
                            TextFieldValue(
                                name,
                                selection = TextRange(name.lastIndex + 1)
                            )
                        )
                        searchScreenViewModel.insertRecentSearch(name)
                    }
                }
            )
        }
    }
}



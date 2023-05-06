package com.example.movies.feature.search.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.examle.movies.core.ui.R
import com.examle.movies.core.ui.components.MoviesErrorView
import com.examle.movies.core.ui.components.MoviesLoadingFooterItem


fun <T : Any> LazyListScope.searchCategoriesList(
    categoryItems: LazyPagingItems<T>,
    onRetryClick: () -> Unit,
    content: @Composable (T?) -> Unit,
) {
    if (categoryItems.itemCount > 0) {
        items(categoryItems) {
            content(it)
        }
    } else {
        item {
            Box(modifier = Modifier.fillParentMaxSize(), contentAlignment = Alignment.Center) {
                SearchCategoriesScreenEmptyView()
            }
        }
    }
    categoryItems.apply {
        when {
            loadState.refresh is LoadState.Loading -> {
                items(10) {
                    SearchShimmerItem()
                }
            }
            loadState.append is LoadState.Loading -> {
                item {
                    MoviesLoadingFooterItem()
                }
            }
            loadState.refresh is LoadState.Error -> {
                item {
                    val message = (loadState.refresh as LoadState.Error).error.localizedMessage
                        ?: stringResource(
                            id = R.string.something_went_wrong_error_message
                        )
                    MoviesErrorView(
                        modifier = Modifier
                            .fillParentMaxSize(),
                        message = message,
                        onRetryClick = onRetryClick
                    )
                }
            }
            loadState.append is LoadState.Error -> {
                item {
                    val message = (loadState.append as LoadState.Error).error.localizedMessage
                        ?: stringResource(
                            id = R.string.something_went_wrong_error_message
                        )
                    MoviesErrorView(
                        message = message,
                        onRetryClick = onRetryClick
                    )
                }
            }
        }
    }
}
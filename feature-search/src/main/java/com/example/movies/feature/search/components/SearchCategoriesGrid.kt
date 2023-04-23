package com.example.movies.feature.search.components

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.examle.movies.core.ui.R
import com.examle.movies.core.ui.components.MoviesErrorView
import com.examle.movies.core.ui.components.MoviesLoadingFooterItem

fun <T : Any> LazyGridScope.searchCategoriesGrid(
    categoryItems: LazyPagingItems<T>,
    onRetryClick: () -> Unit,
    content: @Composable (T?) -> Unit
) {
    items(categoryItems.itemCount) {
        categoryItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    repeat(10) {
                        SearchShimmerItem()
                    }
                }
                loadState.append is LoadState.Loading -> {
                    MoviesLoadingFooterItem()
                }
                loadState.refresh is LoadState.Error -> {
                    val message = (loadState.refresh as LoadState.Error).error.localizedMessage
                        ?: stringResource(
                            id = R.string.something_went_wrong_error_message
                        )
                    MoviesErrorView(
                        modifier = Modifier
                            .wrapContentHeight(),
                        message = message,
                        onRetryClick = onRetryClick
                    )
                }
                loadState.append is LoadState.Error -> {
                    val message = (loadState.append as LoadState.Error).error.localizedMessage
                        ?: stringResource(
                            id = R.string.something_went_wrong_error_message
                        )
                    MoviesErrorView(
                        message = message,
                        onRetryClick = onRetryClick
                    )
                }
                else -> {
                    content(categoryItems[it])
                }
            }
        }
    }
}
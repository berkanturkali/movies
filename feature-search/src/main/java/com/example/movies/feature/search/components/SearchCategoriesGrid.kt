package com.example.movies.feature.search.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.examle.movies.core.ui.R
import com.examle.movies.core.ui.components.MoviesErrorView
import com.examle.movies.core.ui.components.MoviesLoadingFooterItem

fun <T : Any> LazyGridScope.searchCategoriesGrid(
    cellCount: Int,
    shape: RoundedCornerShape,
    categoryItems: LazyPagingItems<T>,
    onRetryClick: () -> Unit,
    content: @Composable (T?) -> Unit
) {
    if (categoryItems.itemCount > 0) {
        items(categoryItems.itemCount) {
            content(categoryItems[it])
        }
    }
    categoryItems.apply {
        when {
            loadState.refresh is LoadState.Loading -> {
                items(10) {
                    SearchGridShimmerItem(shape = shape)
                }
            }
            loadState.append is LoadState.Loading -> {
                item(span = { GridItemSpan(cellCount) }) {
                    MoviesLoadingFooterItem()
                }
            }
            loadState.refresh is LoadState.Error -> {
                item(span = { GridItemSpan(cellCount) }) {
                    val message = (loadState.refresh as LoadState.Error).error.localizedMessage
                        ?: stringResource(
                            id = R.string.something_went_wrong_error_message
                        )
                    MoviesErrorView(
                        modifier = Modifier.fillMaxSize(),
                        message = message,
                        onRetryClick = onRetryClick
                    )
                }
            }
            loadState.append is LoadState.Error -> {
                item(span = { GridItemSpan(cellCount) }) {
                    val message = (loadState.append as LoadState.Error).error.localizedMessage
                        ?: stringResource(
                            id = R.string.something_went_wrong_error_message
                        )
                    MoviesErrorView(
                        message = message,
                        onRetryClick = onRetryClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
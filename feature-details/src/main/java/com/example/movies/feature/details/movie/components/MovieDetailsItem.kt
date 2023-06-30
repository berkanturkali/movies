package com.example.movies.feature.details.movie.components

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.examle.movies.core.ui.R
import com.examle.movies.core.ui.components.MoviesErrorView
import com.example.movies.core.common.Resource

fun <T : Any?> LazyListScope.movieDetailsItem(
    context: Context,
    resource: Resource<T>,
    onRetryClick: () -> Unit,
    content: @Composable (T) -> Unit,
) {
    when (resource) {
        is Resource.Error -> {
            item {
                MoviesErrorView(
                    modifier = Modifier.fillMaxWidth(),
                    message = resource.error?.asString(context) ?: stringResource(
                        id = R.string.something_went_wrong_error_message
                    ),
                    onRetryClick = onRetryClick
                )
            }
        }
        is Resource.Loading -> {
            item {
                MovieDetailsFadeItem()
            }
        }
        is Resource.Success -> {
            resource.data?.let {
                item {
                    content(it)
                }
            }
        }
    }

}
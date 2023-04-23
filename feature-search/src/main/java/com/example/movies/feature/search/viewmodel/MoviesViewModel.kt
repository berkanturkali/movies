package com.example.movies.feature.search.viewmodel

import androidx.paging.PagingData
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val searchRepo: SearchRepository
) : SearchCategoryViewModel() {

    val movies = _query.flatMapLatest { query ->
        if (query.isNotEmpty()) {
            searchRepo.fetchMovies(query)
        } else {
            flowOf(PagingData.empty())
        }
    }
}
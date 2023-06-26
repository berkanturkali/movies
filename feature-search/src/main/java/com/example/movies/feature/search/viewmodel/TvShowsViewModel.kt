package com.example.movies.feature.search.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@HiltViewModel
class TvShowsViewModel @Inject constructor(
    private val searchRepo: SearchRepository
) : SearchCategoryViewModel() {

    val tvShows = query.flatMapLatest { query ->
        if (query.isNotEmpty()) {
            searchRepo.fetchTvShows(query)
                .cachedIn(viewModelScope)
        } else {
            flowOf(PagingData.empty())
        }

    }
}
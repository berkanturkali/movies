package com.example.movies.feature.search.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CompaniesViewModel @Inject constructor(
    private val searchRepo: SearchRepository
) : SearchCategoryViewModel() {
    val companies = _query.flatMapLatest { query ->
        if (query.isNotEmpty()) {
            searchRepo.fetchCompanies(query = query)
                .cachedIn(viewModelScope)
        } else {
            flowOf(PagingData.empty())
        }
    }
}
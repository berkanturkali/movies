package com.example.movies.feature.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val _query = MutableStateFlow<String>("")

    val query
        get() = _query
            .debounce(300)
            .map { query ->
                query.ifBlank { null }
            }

    val keywords = query.flatMapLatest { query ->
        searchRepository.fetchKeywords(query = query)
    }
        .cachedIn(viewModelScope)

    val recentSearches = query.flatMapLatest {
        searchRepository.getRecentSearches(it ?: "")
    }
        .asLiveData()

    fun setQuery(query: String) {
        _query.value = query
    }
}
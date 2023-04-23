package com.example.movies.feature.search.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

abstract class SearchCategoryViewModel : ViewModel() {

    protected val _query = MutableStateFlow("")


    fun setQuery(query: String) {
        _query.value = query
    }
}
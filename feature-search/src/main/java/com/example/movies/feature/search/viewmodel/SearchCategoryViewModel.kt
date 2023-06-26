package com.example.movies.feature.search.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

abstract class SearchCategoryViewModel : ViewModel() {

    protected val query = MutableStateFlow("")

    fun setQuery(query: String) {
        this.query.value = query
    }
}
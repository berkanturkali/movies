package com.example.movies.feature.search.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor() : ViewModel() {

    private val _query = MutableStateFlow<String>("")

    val query
        get() = _query
            .debounce(300)
            .map { query ->
                query.ifEmpty { null }
            }
}
package com.example.movies.feature.search.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SearchCategoriesScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val searchRepository: SearchRepository,
) : ViewModel() {

    companion object {
        const val DEBOUNCE_TIMEOUT_MILLIS: Long = 300
    }

    lateinit var queryArg: String

    lateinit var lastSearchQuery: String

    var isSearchQueryChanged by mutableStateOf(true)

    var focused by mutableStateOf(false)

    private val _queryTextFieldValue = MutableStateFlow<TextFieldValue>(TextFieldValue(text = ""))

    val queryTextFieldValue: StateFlow<TextFieldValue>
        get() = _queryTextFieldValue

    val keywords = queryTextFieldValue
        .debounce(DEBOUNCE_TIMEOUT_MILLIS)
        .filter {
            focused
        }
        .flatMapLatest { value ->
            if (value.text.isNotBlank()) {
                searchRepository.fetchKeywords(query = value.text)
            } else {
                flowOf(PagingData.empty())
            }
        }
        .cachedIn(viewModelScope)

    val recentSearches = queryTextFieldValue.debounce(DEBOUNCE_TIMEOUT_MILLIS)
        .flatMapLatest {
            searchRepository.getRecentSearches(it.text)
        }
        .asLiveData()

    init {
        savedStateHandle.get<String>("query")
            ?.let { query ->
                queryArg = query
                lastSearchQuery = queryArg
                setSearchTextFieldValue(
                    _queryTextFieldValue.value.copy(
                        text = query, selection = TextRange(query.lastIndex + 1)
                    )
                )
            }
    }

    fun setSearchTextFieldValue(textFieldValue: TextFieldValue) {
        _queryTextFieldValue.update {
            textFieldValue
        }
    }

    fun clearQuery() {
        setSearchTextFieldValue(TextFieldValue(text = ""))
    }

    fun checkIfSearchQueryChanged(query: String): Boolean = query.isNotBlank() || queryArg != query


    fun resetTheQuery() {
        setSearchTextFieldValue(
            TextFieldValue(
                text = lastSearchQuery,
                selection = TextRange(queryArg.lastIndex + 1)
            )
        )
    }

}
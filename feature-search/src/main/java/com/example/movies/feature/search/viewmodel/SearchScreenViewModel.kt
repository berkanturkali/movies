package com.example.movies.feature.search.viewmodel

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import com.example.movies.core.model.search.keyword.Keyword
import com.example.movies.feature.search.SearchInputState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    companion object {
        const val DEBOUNCE_TIMEOUT_MILLIS: Long = 300
    }

    private val _textFieldValue = MutableStateFlow<TextFieldValue>(TextFieldValue(text = ""))

    val textFieldValue: StateFlow<TextFieldValue>
        get() = _textFieldValue

    private val _searchInputState = MutableStateFlow<SearchInputState>(SearchInputState.UNFOCUSED)

    val searchInputState: StateFlow<SearchInputState> = _searchInputState.asStateFlow()

    val keywords = textFieldValue
        .distinctUntilChangedBy { it.text }
        .debounce(DEBOUNCE_TIMEOUT_MILLIS)
        .flatMapLatest { value ->
            if (value.text.isNotEmpty()) {
                searchRepository.fetchKeywords(query = value.text)

            } else {
                flowOf(PagingData.empty<Keyword>())
            }
        }
        .cachedIn(viewModelScope)

    val recentSearches = textFieldValue.debounce(DEBOUNCE_TIMEOUT_MILLIS)
        .distinctUntilChangedBy { it.text }
        .flatMapLatest {
            searchRepository.getRecentSearches(it.text)
        }
        .asLiveData()

    fun setSearchTextFieldValue(textFieldValue: TextFieldValue) {
        _textFieldValue.update {
            textFieldValue
        }
    }
    fun clearQuery() {
        setSearchTextFieldValue(TextFieldValue(""))
    }

    fun insertRecentSearch(text: String) {
        viewModelScope.launch(Dispatchers.IO) {
            searchRepository.insertRecentSearch(text)
        }
    }

    fun clearRecentSearches() {
        viewModelScope.launch(Dispatchers.IO) {
            searchRepository.clearAllRecentSearches()
        }
    }

    fun setSearchInputState(searchInputState: SearchInputState) {
        _searchInputState.value = searchInputState
    }
}
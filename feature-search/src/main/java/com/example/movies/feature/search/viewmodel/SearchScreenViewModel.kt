package com.example.movies.feature.search.viewmodel

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import com.example.movies.core.model.search.keyword.Keyword
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


    val keywords = textFieldValue.debounce(DEBOUNCE_TIMEOUT_MILLIS)
        .flatMapLatest { value ->
            if (value.text.isNotEmpty()) {
                searchRepository.fetchKeywords(query = value.text)
                    .cachedIn(viewModelScope)
            } else {
                flowOf(PagingData.empty<Keyword>())
            }
        }

    val recentSearches = textFieldValue.debounce(DEBOUNCE_TIMEOUT_MILLIS)
        .flatMapLatest {
            searchRepository.getRecentSearches(it.text)
        }
        .asLiveData()

    fun setSearchTextFieldValue(textFieldValue: TextFieldValue) {
        _textFieldValue.update {
            textFieldValue
        }
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
}
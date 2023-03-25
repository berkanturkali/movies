package com.example.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {


    private val _scrollToTop = Channel<Boolean>()

    val scrollToTop: Flow<Boolean> get() = _scrollToTop.receiveAsFlow()


    fun setScrollToTop(scrollToTop: Boolean) {
        viewModelScope.launch {
            _scrollToTop.send(scrollToTop)
        }
    }

}
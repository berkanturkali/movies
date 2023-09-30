package com.example.feature.cast.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.movies.core.model.moviedetails.Cast
import com.example.movies.core.navigation.args.cast.CastScreenArgConstants
import com.example.movies.core.navigation.args.cast.CastScreenArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CastScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _cast = MutableLiveData<List<Cast>>()

    val cast: LiveData<List<Cast>> get() = _cast

    init {
        savedStateHandle.get<CastScreenArgs>(CastScreenArgConstants.CAST_SCREEN_ARG_KEY)
            ?.let { args ->
                _cast.value = args.castList
            }
    }
}
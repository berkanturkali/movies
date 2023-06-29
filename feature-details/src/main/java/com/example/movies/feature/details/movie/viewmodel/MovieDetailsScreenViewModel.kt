package com.example.movies.feature.details.movie.viewmodel

import androidx.lifecycle.*
import com.example.movies.core.common.Resource
import com.example.movies.core.model.moviedetails.Cast
import com.example.movies.core.model.moviedetails.Keyword
import com.example.movies.core.model.moviedetails.Movie
import com.example.movies.core.model.moviedetails.Reviews
import com.example.movies.core.navigation.args.moviedetails.MovieDetailsScreenArgs
import com.example.movies.feature.details.movie.usecases.MovieDetailsScreenUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsScreenViewModel @Inject constructor(
    private val movieDetailsScreenUseCases: MovieDetailsScreenUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _movie = MutableLiveData<Resource<Movie>>()

    val movie: LiveData<Resource<Movie>> get() = _movie

    private val _cast = MutableLiveData<Resource<List<Cast?>>>()

    val cast: LiveData<Resource<List<Cast?>>> get() = _cast

    private val _reviews = MutableLiveData<Resource<Reviews>>()

    val reviews: LiveData<Resource<Reviews>> get() = _reviews

    private val _keywords = MutableLiveData<Resource<List<Keyword>>>()

    val keywords: LiveData<Resource<List<Keyword>>> get() = _keywords

    private var id: Int? = null

    init {
        savedStateHandle.get<Int>(MovieDetailsScreenArgs.MOVIE_ID_ARG_KEY)
            ?.let { id ->
                this.id = id
                fetchMovie(id)
            }
    }


    fun fetchMovie(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            movieDetailsScreenUseCases.fetchMovie(id)
                .onEach {
                    if (it is Resource.Success && it.data != null) {

                    }
                    _movie.value = it
                }
        }
    }

    fun fetchCast(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            movieDetailsScreenUseCases.fetchCast(id)
                .onEach {
                    _cast.value = it
                }
        }
    }

    fun fetchReviews(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            movieDetailsScreenUseCases.fetchReviews(id)
                .onEach {
                    _reviews.value = it
                }

        }
    }

    fun fetchKeywords(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            movieDetailsScreenUseCases.fetchKeywords(id)
                .onEach {
                    _keywords.value = it
                }
        }
    }

}
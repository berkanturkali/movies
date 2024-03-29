package com.example.movies.feature.details.movie.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.*
import com.example.movies.core.common.Resource
import com.example.movies.core.model.moviedetails.*
import com.example.movies.core.navigation.args.moviedetails.MovieDetailsScreenArgConstants
import com.example.movies.feature.details.movie.usecases.MovieDetailsScreenUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    private val _videos = MutableLiveData<Resource<List<Video>>>()

    val videos: LiveData<Resource<List<Video>>> get() = _videos

    private val _recommendations = MutableLiveData<Resource<List<Recommendation>>>()

    val recommendations: LiveData<Resource<List<Recommendation>>> get() = _recommendations

    private val _liked = MutableLiveData<Boolean>()

    val liked: LiveData<Boolean> get() = _liked

    private var id: Int = 0

    init {
        savedStateHandle.get<Int>(MovieDetailsScreenArgConstants.MOVIE_ID_ARG_KEY)
            ?.let { id ->
                this.id = id
                checkIfMovieIsInFavorites(id)
                fetchMovie(id)
            }
    }


    fun fetchMovie(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            movieDetailsScreenUseCases.fetchMovie(id)
                .collect {
                    if (it is Resource.Success && it.data != null) {
                        fetchCast()
                        fetchReviews()
                        fetchKeywords()
                        fetchVideos()
                        fetchRecommendations()
                    }
                    _movie.value = it
                }
        }
    }

    fun fetchCast() {
        viewModelScope.launch(Dispatchers.Main) {
            movieDetailsScreenUseCases.fetchCast(id)
                .collect {
                    _cast.value = it
                }
        }
    }

    fun fetchReviews() {
        viewModelScope.launch(Dispatchers.Main) {
            movieDetailsScreenUseCases.fetchReviews(id)
                .collect {
                    _reviews.value = it
                }

        }
    }

    fun fetchKeywords() {
        viewModelScope.launch(Dispatchers.Main) {
            movieDetailsScreenUseCases.fetchKeywords(id)
                .collect {
                    _keywords.value = it
                }
        }
    }

    fun fetchVideos() {
        viewModelScope.launch(Dispatchers.Main) {
            movieDetailsScreenUseCases.fetchVideos(id)
                .collect {
                    _videos.value = it
                }
        }
    }

    fun fetchRecommendations() {
        viewModelScope.launch(Dispatchers.Main) {
            movieDetailsScreenUseCases.fetchRecommendations(id)
                .collect {
                    _recommendations.value = it
                }
        }
    }

    fun calculateColorCodeFromScore(score: Float?): Color? =
        movieDetailsScreenUseCases.calculateColorCodeFromScore(score)

    fun addMovieToFavorites(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            movieDetailsScreenUseCases.addMovieToFavorites(movie)
        }
    }

    fun removeMovieFromFavorites(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            movieDetailsScreenUseCases.removeMovieFromFavorites(movie)
        }
    }

    fun setLiked(liked: Boolean) {
        _liked.value = liked
    }

    private fun checkIfMovieIsInFavorites(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            _liked.value = withContext(
                Dispatchers.IO
            ) { movieDetailsScreenUseCases.checkIfTheMovieIsInFavorites(id) }
        }
    }
}
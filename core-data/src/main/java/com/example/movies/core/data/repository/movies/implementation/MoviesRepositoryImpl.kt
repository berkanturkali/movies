package com.example.movies.core.data.repository.movies.implementation

import com.example.movies.core.common.Resource
import com.example.movies.core.data.repository.movies.abstraction.MoviesRepository
import com.example.movies.core.data.utils.safeApiCall
import com.example.movies.core.model.moviedetails.*
import com.example.movies.core.network.datasource.abstraction.movies.MoviesRemoteDataSource
import com.example.movies.core.network.mapper.moviedetails.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val movieDetailsResponseMapper: MovieDetailsResponseMapper,
    private val castResponseMapper: CastResponseMapper,
    private val reviewsResponseMapper: ReviewsResponseMapper,
    private val keywordMapper: KeywordMapper,
    private val videoMapper: VideoMapper,
    private val recommendationMapper: RecommendationMapper,
) : MoviesRepository {

    override suspend fun fetchMovie(id: Int): Flow<Resource<Movie>> {
        return safeApiCall(mapFromModel = movieDetailsResponseMapper::mapFromModel) {
            remoteDataSource.fetchMovie(id)
        }
    }

    override suspend fun fetchCast(id: Int): Flow<Resource<List<Cast?>>> {
        return safeApiCall(mapFromModel = { creditResponseDTO ->
            if (creditResponseDTO.cast != null) {
                creditResponseDTO.cast!!.map { castDTO ->
                    castDTO?.let {
                        castResponseMapper.mapFromModel(it)
                    }
                }
            } else {
                emptyList()
            }
        }) {
            remoteDataSource.fetchCredits(id)
        }
    }

    override suspend fun fetchReviews(id: Int): Flow<Resource<Reviews>> {
        return safeApiCall(
            mapFromModel = reviewsResponseMapper::mapFromModel
        ) {
            remoteDataSource.fetchReviews(id)
        }
    }

    override suspend fun fetchKeywords(id: Int): Flow<Resource<List<Keyword>>> {
        return safeApiCall(
            mapFromModel = { response ->
                if (response.keywords != null) {
                    val list = response.keywords!!.filterNotNull()
                        .map {
                            keywordMapper.mapFromModel(it)
                        }
                    list
                } else {
                    emptyList()
                }
            }
        ) {
            remoteDataSource.fetchKeywords(id)
        }
    }

    override suspend fun fetchVideos(id: Int): Flow<Resource<List<Video>>> {
        return safeApiCall(mapFromModel = { response ->
            if (response.results != null) {
                val list = response.results!!.filterNotNull()
                    .map {
                        videoMapper.mapFromModel(it)
                    }
                list
            } else {
                emptyList()
            }
        }) {
            remoteDataSource.fetchVideos(id)
        }
    }

    override suspend fun fetchRecommendations(id: Int): Flow<Resource<List<Recommendation>>> {
        return safeApiCall(
            mapFromModel = { response ->
                if (response.results != null) {
                    val list = response.results!!.filterNotNull()
                        .map {
                            recommendationMapper.mapFromModel(it)
                        }
                    list
                } else {
                    emptyList()
                }
            }
        ) {
            remoteDataSource.fetchRecommendations(id)
        }
    }
}
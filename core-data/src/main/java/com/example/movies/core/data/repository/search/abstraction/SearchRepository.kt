package com.example.movies.core.data.repository.search.abstraction

import androidx.paging.PagingData
import com.example.movies.core.model.search.company.Company
import com.example.movies.core.network.model.search.collection.CollectionDTO
import com.example.movies.core.network.model.search.keyword.KeywordDTO
import com.example.movies.core.network.model.search.movie.MovieDTO
import com.example.movies.core.network.model.search.people.PersonDTO
import com.example.movies.core.network.model.search.tvshow.TvShowDTO
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    suspend fun fetchCompanies(
        page: Int,
        query: String?,
    ): Flow<PagingData<Company>>

    suspend fun fetchCollections(
        page: Int,
        query: String?,
    ): Flow<PagingData<CollectionDTO>>

    suspend fun fetchKeywords(
        page: Int,
        query: String?,
    ): Flow<PagingData<KeywordDTO>>

    suspend fun fetchMovies(
        page: Int,
        query: String?,
    ): Flow<PagingData<MovieDTO>>

    suspend fun fetchPeople(
        page: Int,
        query: String?,
    ): Flow<PagingData<PersonDTO>>

    suspend fun fetchTvShow(
        page: Int,
        query: String?,
    ): Flow<PagingData<TvShowDTO>>
}
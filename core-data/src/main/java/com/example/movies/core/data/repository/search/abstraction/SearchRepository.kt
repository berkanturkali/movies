package com.example.movies.core.data.repository.search.abstraction

import androidx.paging.PagingData
import com.example.movies.core.model.search.collection.Collection
import com.example.movies.core.model.search.company.Company
import com.example.movies.core.model.search.keyword.Keyword
import com.example.movies.core.model.search.movie.Movie
import com.example.movies.core.model.search.person.Person
import com.example.movies.core.model.search.tv_show.TvShow
import com.example.movies.core.network.model.search.keyword.KeywordDTO
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
    ): Flow<PagingData<Collection>>

    suspend fun fetchKeywords(
        query: String?,
    ): Flow<PagingData<Keyword>>

    suspend fun fetchMovies(
        page: Int,
        query: String?,
    ): Flow<PagingData<Movie>>

    suspend fun fetchPeople(
        page: Int,
        query: String?,
    ): Flow<PagingData<Person>>

    suspend fun fetchTvShows(
        page: Int,
        query: String?,
    ): Flow<PagingData<TvShow>>
}
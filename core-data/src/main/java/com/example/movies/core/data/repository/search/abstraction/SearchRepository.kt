package com.example.movies.core.data.repository.search.abstraction

import androidx.paging.PagingData
import com.example.movies.core.model.search.collection.Collection
import com.example.movies.core.model.search.company.Company
import com.example.movies.core.model.search.keyword.Keyword
import com.example.movies.core.model.search.movie.Movie
import com.example.movies.core.model.search.person.Person
import com.example.movies.core.model.search.recentsearch.RecentSearch
import com.example.movies.core.model.search.tvshow.TvShow
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    suspend fun fetchCompanies(
        query: String,
    ): Flow<PagingData<Company>>

    suspend fun fetchCollections(
        query: String,
    ): Flow<PagingData<Collection>>

    suspend fun fetchKeywords(
        query: String,
    ): Flow<PagingData<Keyword>>

    suspend fun fetchMovies(
        query: String,
    ): Flow<PagingData<Movie>>

    suspend fun fetchPeople(
        query: String,
    ): Flow<PagingData<Person>>

    suspend fun fetchTvShows(
        query: String,
    ): Flow<PagingData<TvShow>>

    suspend fun insertRecentSearch(recentSearch:String): Long

    fun getRecentSearches(query: String): Flow<List<RecentSearch>>

    suspend fun deleteRecentSearch(recentSearch:String)

    suspend fun clearAllRecentSearches()

}
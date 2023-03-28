package com.example.movies.core.network.datasource.abstraction.search

import com.example.movies.core.network.model.search.collection.CollectionDTO
import com.example.movies.core.network.model.search.company.CompanyDTO
import com.example.movies.core.network.model.search.keyword.KeywordDTO
import com.example.movies.core.network.model.search.movie.MovieDTO
import com.example.movies.core.network.model.search.people.PersonDTO
import com.example.movies.core.network.model.search.tvshow.TvShowDTO

interface SearchRemoteDataSource {

    suspend fun fetchCompanies(
        page: Int,
        query: String,
    ): List<CompanyDTO>

    suspend fun fetchCollections(
        page: Int,
        query: String,
    ): List<CollectionDTO>

    suspend fun fetchKeywords(
        page: Int,
        query: String,
    ): List<KeywordDTO>

    suspend fun fetchMovies(
        page: Int,
        query: String,
    ): List<MovieDTO>

    suspend fun fetchPeople(
        page: Int,
        query: String,
    ): List<PersonDTO>

    suspend fun fetchTvShow(
        page: Int,
        query: String,
    ): List<TvShowDTO>
}
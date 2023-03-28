package com.example.movies.core.network.datasource.implementation.search

import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.model.search.collection.CollectionDTO
import com.example.movies.core.network.model.search.company.CompanyDTO
import com.example.movies.core.network.model.search.keyword.KeywordDTO
import com.example.movies.core.network.model.search.movie.MovieDTO
import com.example.movies.core.network.model.search.people.PersonDTO
import com.example.movies.core.network.model.search.tvshow.TvShowDTO
import com.example.movies.core.network.service.search.SearchService
import javax.inject.Inject

class SearchRemoteDataSourceImpl @Inject constructor(
    private val service:SearchService
): SearchRemoteDataSource {
    override suspend fun fetchCompanies(page: Int, query: String): List<CompanyDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchCollections(page: Int, query: String): List<CollectionDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchKeywords(page: Int, query: String): List<KeywordDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchMovies(page: Int, query: String): List<MovieDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchPeople(page: Int, query: String): List<PersonDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchTvShow(page: Int, query: String): List<TvShowDTO> {
        TODO("Not yet implemented")
    }
}
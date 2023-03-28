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
    private val service: SearchService
) : SearchRemoteDataSource {
    override suspend fun fetchCompanies(page: Int, query: String?): List<CompanyDTO> {
        return service.fetchCompanies(page, query).companies
    }

    override suspend fun fetchCollections(page: Int, query: String?): List<CollectionDTO> {
        return service.fetchCollections(page, query).collections
    }

    override suspend fun fetchKeywords(page: Int, query: String?): List<KeywordDTO> {
        return service.fetchKeywords(page, query).keywords
    }

    override suspend fun fetchMovies(page: Int, query: String?): List<MovieDTO> {
        return service.fetchMovies(page, query).movies
    }

    override suspend fun fetchPeople(page: Int, query: String?): List<PersonDTO> {
        return service.fetchPeople(page, query).people
    }

    override suspend fun fetchTvShow(page: Int, query: String?): List<TvShowDTO> {
        return service.fetchTvShow(page, query).shows
    }
}
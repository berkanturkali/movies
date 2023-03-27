package com.example.movies.core.network.service.search

import com.example.movies.core.network.endpoints.search.SearchEndpoints
import com.example.movies.core.network.model.search.collection.CollectionsResponseDTO
import com.example.movies.core.network.model.search.company.CompaniesResponseDTO
import com.example.movies.core.network.model.search.keyword.KeywordsResponseDTO
import com.example.movies.core.network.model.search.movie.MoviesResponseDTO
import com.example.movies.core.network.model.search.people.PeopleResponseDTO
import com.example.movies.core.network.model.search.tvshow.TvShowsResponseDTO
import com.example.movies.core.network.service.base.BaseService
import retrofit2.http.GET

interface SearchService : BaseService {

    @GET(SearchEndpoints.COMPANY_ENDPOINT)
    suspend fun fetchCompanies(): CompaniesResponseDTO

    @GET(SearchEndpoints.COLLECTION_ENDPOINT)
    suspend fun fetchCollections(): CollectionsResponseDTO

    @GET(SearchEndpoints.KEYWORD_ENDPOINT)
    suspend fun fetchKeywords(): KeywordsResponseDTO

    @GET(SearchEndpoints.MOVIE_ENDPOINT)
    suspend fun fetchMovies(): MoviesResponseDTO

    @GET(SearchEndpoints.PEOPLE_ENDPOINT)
    suspend fun fetchPeople(): PeopleResponseDTO

    @GET(SearchEndpoints.TV_ENDPOINT)
    suspend fun fetchTvShow(): TvShowsResponseDTO

}
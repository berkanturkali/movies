package com.example.movies.core.model.search

sealed class SearchScreenContent(open val query: String? = null) {

    data class SearchScreen(override val query: String?) : SearchScreenContent(query)

    data class SearchCategoriesScreen(override val query: String) : SearchScreenContent(query)
}
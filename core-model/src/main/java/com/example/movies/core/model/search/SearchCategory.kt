package com.example.movies.core.model.search

import androidx.annotation.StringRes
import com.example.movies.core.model.R

enum class SearchCategory(@StringRes val categoryResId: Int) {

    COMPANIES(categoryResId = R.string.search_category_companies),
    COLLECTIONS(categoryResId = R.string.search_category_collections),
    KEYWORD(categoryResId = R.string.search_category_keyword),
    MOVIES(categoryResId = R.string.search_category_movies),
    PEOPLE(categoryResId = R.string.search_category_people),
    SHOWS(categoryResId = R.string.search_category_shows)
}
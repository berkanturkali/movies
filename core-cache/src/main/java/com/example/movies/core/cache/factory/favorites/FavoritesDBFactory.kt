package com.example.movies.core.cache.factory.favorites

import android.content.Context
import com.example.movies.core.cache.BuildConfig
import com.example.movies.core.cache.db.favorites.FavoritesDatabase
import com.example.movies.core.cache.factory.AbstractDBFactory
import com.example.movies.core.cache.factory.DBFactory

object FavoritesDBFactory : AbstractDBFactory<FavoritesDatabase>() {
    override fun createDatabase(context: Context): FavoritesDatabase {
        return DBFactory.createDatabase(context, BuildConfig.favoritesDatabaseName)
    }
}
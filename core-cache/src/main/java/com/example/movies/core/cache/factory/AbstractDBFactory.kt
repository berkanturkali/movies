package com.example.movies.core.cache.factory

import android.content.Context
import com.example.movies.core.cache.db.base.BaseDatabase

abstract class AbstractDBFactory<T : BaseDatabase> {
    abstract fun createDatabase(context: Context): T
}
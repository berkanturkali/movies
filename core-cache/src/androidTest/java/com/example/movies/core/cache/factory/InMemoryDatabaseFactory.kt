package com.example.movies.core.cache.factory

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.movies.core.cache.db.base.BaseDatabase

object InMemoryDatabaseFactory {

    inline fun <reified T : BaseDatabase> createInMemoryDatabase(): T {
        return Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            T::class.java
        )
            .allowMainThreadQueries()
            .build()
    }
}
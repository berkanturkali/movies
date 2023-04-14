package com.example.movies.core.cache.factory

import android.content.Context
import androidx.room.Room
import com.example.movies.core.cache.db.base.BaseDatabase

object DBFactory {
    inline fun <reified T : BaseDatabase> createDatabase(
        context: Context,
        databaseName: String
    ): T {
        return Room.databaseBuilder(
            context.applicationContext,
            T::class.java,
            databaseName
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}
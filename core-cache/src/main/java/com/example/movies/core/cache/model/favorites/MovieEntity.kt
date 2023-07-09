package com.example.movies.core.cache.model.favorites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo("name")
    val name: String? = null,
    @ColumnInfo("image")
    val image: String? = null,
)
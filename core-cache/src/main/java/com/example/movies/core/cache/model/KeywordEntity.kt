package com.example.movies.core.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "keywords")
data class KeywordEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val name: String? = null
)
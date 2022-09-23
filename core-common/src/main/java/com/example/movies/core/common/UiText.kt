package com.example.movies.core.common

sealed class UiText {
    data class DynamicString(val value:String?) : UiText()


}
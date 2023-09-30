package com.example.movies.core.navigation.args.cast.navtype

import com.example.movies.core.navigation.args.cast.CastScreenArgs

data class CastScreenArgsNavType(override val isNullableAllowed: Boolean = false) :
    BaseNavType<CastScreenArgs>(isNullableAllowed) {
    override fun parseValue(value: String): CastScreenArgs {
        return moshi.parseValue(value)
    }

}
package com.example.movies.core.data.fakes.datasource

import java.io.IOException

abstract class BaseFakeDataSource {

    protected var returnError: Boolean = false
        private set

    protected var successButNull: Boolean = false
        private set

    protected var throwException: Boolean = false
        private set

    protected var exception: Exception = IOException()
        private set

    protected var errorCode: Int = 401
        private set

    val errorResponse =
        "{\"success\":false,\"status_code\":22,\"status_message\":\"Invalidpage:Pages start at 1 and max at 1000.They are expected to be an integer.\"}"


    internal fun setReturnError(returnError: Boolean) {
        this.returnError = returnError
    }

    internal fun setSuccessButNull(successButNull: Boolean) {
        this.successButNull = successButNull
    }

    internal fun setThrowException(throwException: Boolean) {
        this.throwException = throwException
    }

    internal fun setErrorCode(code: Int) {
        errorCode = code
    }

    internal fun setException(exception: Exception) {
        this.exception = exception
    }

}
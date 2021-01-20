package com.eniola.studyapp.remote.api

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Jan-2021
 */

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T): ResultWrapper<T>()
    data class Error(
        val errorCode: Int? = null,
        val errorMessage: String? = null): ResultWrapper<Nothing>()
    data class Loading<out T>(val value: T): ResultWrapper<T>()

}
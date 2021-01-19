package com.eniola.studyapp.remote.api

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Jan-2021
 */

sealed class NetworkStatus<out T> {
    data class Success<out T>(val value: T): NetworkStatus<T>()
    data class Error(
        val errorCode: Int? = null,
        val errorMessage: String? = null): NetworkStatus<Nothing>()
    data class Loading<out T>(val value: T): NetworkStatus<T>()

}
package com.eniola.studyapp.remote.api

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Jan-2021
 */
suspend fun<T> safeApiCall(
    apiCall : suspend () -> T, dispatcher: CoroutineDispatcher = Dispatchers.IO) {

}
package com.eniola.studyapp.ui.subjects

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eniola.studyapp.databases.AppRoomDatabase
import com.eniola.studyapp.remote.NetworkService
import com.eniola.studyapp.remote.api.ResultWrapper
import com.eniola.studyapp.remote.api.safeAPICall
import com.eniola.studyapp.utility.runIO
import kotlinx.coroutines.Job
import javax.inject.Inject

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Jan-2021
 */

class SubjectViewModel @Inject constructor(
    private val networkService: NetworkService,
    private val database: AppRoomDatabase
): ViewModel() {

    val state = MutableLiveData<ViewState>()
    private val job = Job()

    fun cancelJob(){
        job.cancel()
    }

    //make api call to fetch all subjects from API
    fun fetchAllSubject(){
        state.postValue(ViewState.LOADING(true))
        runIO{
            when(val allSubjects = safeAPICall {
                networkService.apiService.getAllSubjects()
            }) {
                //save data in database
                is ResultWrapper.Success -> when (val saveSubjectLocally = safeAPICall {
                    val allSubjects = allSubjects.value.data.subjects
                    database.subjectDao().insertAllSubjects(allSubjects)
                }) {
                    is ResultWrapper.Success -> {
                        state.postValue(ViewState.LOADING(false))


                        //pass data to fragment class
                        val subjectList = allSubjects.value.data.subjects
                        val responseMessage = allSubjects.value.data.message
                        state.postValue(ViewState.SUCCESS(responseMessage, subjectList))
                    }

                    is ResultWrapper.Error ->  {
                        val errorMessage = "An error occured while saving data"
                        state.postValue(ViewState.LOADING(false))
                        state.postValue(errorMessage?.let { ViewState.ERROR(it) })
                    }

                }

                is ResultWrapper.Error ->  {
                    val errorMessage = allSubjects.errorMessage
                    state.postValue(ViewState.LOADING(false))
                    state.postValue(errorMessage?.let { ViewState.ERROR(it) })
                }

            }
        }
    }


}

sealed class ViewState {
    data class SUCCESS(val message: String, val data: List<SubjectData>): ViewState()
    data class LOADING(val loading: Boolean = false) : ViewState()
    data class ERROR(val errorMessage: String): ViewState()

}
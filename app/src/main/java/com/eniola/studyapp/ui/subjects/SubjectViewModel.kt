package com.eniola.studyapp.ui.subjects

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eniola.studyapp.databases.AppRoomDatabase
import com.eniola.studyapp.databases.repository.Repository
import com.eniola.studyapp.remote.NetworkService
import com.eniola.studyapp.remote.api.ResultWrapper
import com.eniola.studyapp.remote.api.safeAPICall
import com.eniola.studyapp.ui.data.RecentActivity
import com.eniola.studyapp.ui.data.SubjectData
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
    private val database: AppRoomDatabase,
    private val repository: Repository
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
                    database.subjectDao().insertAllSubjects(allSubjects.value.data.subjects)
                }) {
                    is ResultWrapper.Success -> {
                        state.postValue(ViewState.LOADING(false))
                        //pass data to fragment class
                        val subjectList = allSubjects.value.data.subjects
                        val responseMessage = allSubjects.value.data.message
                        state.postValue(ViewState.SUCCESS(responseMessage, subjectList))
                    }

                    is ResultWrapper.Error ->  {
                        state.postValue(ViewState.LOADING(false))
                        state.postValue(saveSubjectLocally.errorMessage?.let { ViewState.ERROR(it) })
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

    fun fetchLessonDetails(subjectId: Int){
        runIO {
            val subjectInfo = repository.fetchSubjectDetails(subjectId)
            //save all chapters in database
            subjectInfo.chapters?.let { database.chaptersDao().insertChapter(it) }
            state.postValue(ViewState.SUBJECTDETAILS(subjectInfo))
        }
    }

    fun insertIntoRecentActivity(recentActivity: RecentActivity){
        runIO {
            repository.insertIntoRecentActivity(recentActivity)
        }
    }

    fun fetchFewRecentActivity(){
        runIO {
            state.postValue(ViewState.RECENTACTIVITY(repository.fetchFewRecentActivity()))
        }
    }

    fun fetchAllRecentActivity(){
        runIO {
            state.postValue(ViewState.RECENTACTIVITY(repository.fetchAllRecentActivity()))
        }
    }

}

sealed class ViewState {
    data class SUCCESS(val message: String, val data: List<SubjectData>): ViewState()
    data class LOADING(val loading: Boolean = false) : ViewState()
    data class ERROR(val errorMessage: String): ViewState()
    data class SUBJECTDETAILS(val subjectInformation: SubjectData): ViewState()
    data class RECENTACTIVITY(val recentActivity: List<RecentActivity>): ViewState()

}
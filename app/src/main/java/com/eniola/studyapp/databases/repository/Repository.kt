package com.eniola.studyapp.databases.repository

import com.eniola.studyapp.databases.AppRoomDatabase
import com.eniola.studyapp.ui.data.Lessons
import com.eniola.studyapp.ui.data.SubjectData
import com.eniola.studyapp.ui.data.SubjectInfo
import javax.inject.Inject

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 20-Jan-2021
 */


class Repository @Inject constructor(private val database: AppRoomDatabase){

    suspend fun fetchSubjectDetails(subjectId:Int): SubjectData {
        return database.subjectDao().fetchSubjectDetail(subjectId)
    }

}
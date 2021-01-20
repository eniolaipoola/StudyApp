package com.eniola.studyapp.databases.repository

import com.eniola.studyapp.databases.AppRoomDatabase
import com.eniola.studyapp.ui.data.RecentActivity
import com.eniola.studyapp.ui.data.SubjectData
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

    suspend fun insertIntoRecentActivity(recentActivity: RecentActivity) {
        return database.recentActivityDao().insertIntoRecentActivity(recentActivity)
    }

    suspend fun fetchAllRecentActivity(): List<RecentActivity>{
        return database.recentActivityDao().fetchAll()
    }

    suspend fun fetchFewRecentActivity(): List<RecentActivity>{
        return database.recentActivityDao().fetchFew()
    }

}
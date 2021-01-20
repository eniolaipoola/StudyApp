package com.eniola.studyapp.databases

import android.content.Context
import androidx.room.*
import com.eniola.studyapp.BuildConfig
import com.eniola.studyapp.databases.daos.ChapterDao
import com.eniola.studyapp.databases.daos.LessonDao
import com.eniola.studyapp.databases.daos.SubjectDao
import com.eniola.studyapp.ui.data.Chapters
import com.eniola.studyapp.ui.data.Lessons
import com.eniola.studyapp.ui.data.SubjectData

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Jan-2021
 */

@Database(entities = [SubjectData::class, Lessons::class, Chapters::class], version = 1, exportSchema = false)

@TypeConverters(Converter::class)
abstract class AppRoomDatabase: RoomDatabase()  {
    companion object {
        private val DATABASE_NAME =
            if(BuildConfig.DEBUG) "study_app_stage_db" else "study_app@@@.db"
        private var sInstance: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase? {
            if(sInstance == null){
               synchronized(AppRoomDatabase::class.java){
                   sInstance = Room.databaseBuilder(context,
                       AppRoomDatabase::class.java, DATABASE_NAME)
                       .build()
               }
            }
            return sInstance
        }
    }

    abstract fun subjectDao(): SubjectDao
    abstract fun lessonDao(): LessonDao
    abstract fun chaptersDao(): ChapterDao

}
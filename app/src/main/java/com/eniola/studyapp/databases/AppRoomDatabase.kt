package com.eniola.studyapp.databases

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eniola.studyapp.BuildConfig

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Jan-2021
 */

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
}
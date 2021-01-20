package com.eniola.studyapp.databases

import androidx.room.TypeConverter
import com.eniola.studyapp.ui.subjects.Chapters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Copyright (c) 2020 Eniola Ipoola
 * All rights reserved
 * Created on 03-Feb-2020
 */
class Converter {

    @TypeConverter
    fun fromChapter(metaData: List<Chapters>): String {
        val gson = Gson()
        return gson.toJson(metaData)
    }

    @TypeConverter
    fun toChapter(metaDataString: String): List<Chapters> {
        val gson = Gson()
        val type = object :
            TypeToken<Chapters>() {}.type
        return gson.fromJson(metaDataString, type)
    }

}
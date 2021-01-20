package com.eniola.studyapp.databases

import androidx.room.TypeConverter
import com.eniola.studyapp.ui.data.Chapters
import com.eniola.studyapp.ui.data.Lessons
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Copyright (c) 2020 Eniola Ipoola
 * All rights reserved
 * Created on 03-Feb-2020
 */
class Converter {

    @TypeConverter
    fun fromChapter(chapters: List<Chapters>): String {
        val gson = Gson()
        return gson.toJson(chapters)
    }

    @TypeConverter
    fun toChapter(chapterString: String): List<Chapters> {
        val gson = Gson()
        val type = object :
            TypeToken<List<Chapters>>() {}.type
        return gson.fromJson(chapterString, type)
    }

    @TypeConverter
    fun toLesson(lesson: String): List<Lessons> {
        val gson = Gson()
        val type = object :
            TypeToken<Chapters>() {}.type
        return gson.fromJson(lesson, type)
    }

    @TypeConverter
    fun fromLesson(lessons: List<Lessons>): String {
        val gson = Gson()
        return gson.toJson(lessons)
    }

}
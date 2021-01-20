package com.eniola.studyapp.ui.subjects

import com.eniola.studyapp.ui.data.Chapters
import com.eniola.studyapp.ui.data.Lessons
import com.eniola.studyapp.ui.data.SubjectData
import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 20-Jan-2021
 */

object TestObjectFactory {

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(1, 1000 + 1)
    }

    fun randomString(): String {
        return UUID.randomUUID().toString()
    }

    fun makeChapter(): Chapters {
        return Chapters(randomInt(), randomString(), listOf(makeLesson()) )
    }

    fun makeLesson(): Lessons {
        return Lessons(randomInt(), randomString(), randomString(), randomString(), randomInt(), randomInt())
    }

    fun makeSubject(): List<SubjectData>{
        return listOf(SubjectData(
            randomInt(),
            randomString(),
            randomString(),
            listOf(makeChapter())) )
    }

}
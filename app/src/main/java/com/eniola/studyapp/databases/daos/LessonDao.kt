package com.eniola.studyapp.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eniola.studyapp.ui.data.Lessons
import com.eniola.studyapp.ui.data.SubjectData

@Dao
interface LessonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLessons(lessons: List<Lessons>) : List<Long>

    @Query("select * from Lessons where subject_id=:subjectId and chapter_id=:chapterId")
    suspend fun fetchLesson(subjectId:Int, chapterId:Int): Lessons

}
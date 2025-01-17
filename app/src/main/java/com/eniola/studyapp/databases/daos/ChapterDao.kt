package com.eniola.studyapp.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.eniola.studyapp.ui.data.Chapters
import com.eniola.studyapp.ui.data.SubjectData

@Dao
interface ChapterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChapter(chapters: List<Chapters>) : List<Long>

}
package com.eniola.studyapp.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.eniola.studyapp.ui.subjects.SubjectData

@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSubjects(banks: List<SubjectData>) : List<Long>

}
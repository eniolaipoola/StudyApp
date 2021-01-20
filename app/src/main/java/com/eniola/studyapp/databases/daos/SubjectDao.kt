package com.eniola.studyapp.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eniola.studyapp.ui.data.SubjectData

@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSubjects(banks: List<SubjectData>) : List<Long>

    @Query("select * from SubjectData where id=:subjectId")
    suspend fun fetchSubjectDetail(subjectId:Int): SubjectData


}
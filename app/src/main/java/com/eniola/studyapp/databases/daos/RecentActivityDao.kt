package com.eniola.studyapp.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eniola.studyapp.ui.data.Chapters
import com.eniola.studyapp.ui.data.RecentActivity
import com.eniola.studyapp.ui.data.SubjectData

@Dao
interface RecentActivityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoRecentActivity(recentActivity: RecentActivity)

    @Query("select * from RecentActivity")
    suspend fun fetchAll(): List<RecentActivity>

    @Query("select * from RecentActivity limit 2")
    suspend fun fetchFew(): List<RecentActivity>


}
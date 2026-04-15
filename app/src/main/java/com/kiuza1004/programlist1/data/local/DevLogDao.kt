package com.kiuza1004.programlist1.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DevLogDao {
    @Query("SELECT * FROM dev_logs ORDER BY createdAt DESC")
    fun getAllLogs(): Flow<List<DevLogEntity>>

    @Query("SELECT * FROM dev_logs WHERE category = :category ORDER BY createdAt DESC")
    fun getLogsByCategory(category: String): Flow<List<DevLogEntity>>

    @Query("SELECT * FROM dev_logs WHERE title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%'")
    fun searchLogs(query: String): Flow<List<DevLogEntity>>

    @Query("SELECT * FROM dev_logs WHERE id = :id")
    suspend fun getLogById(id: Long): DevLogEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLog(log: DevLogEntity)

    @Update
    suspend fun updateLog(log: DevLogEntity)

    @Delete
    suspend fun deleteLog(log: DevLogEntity)
}

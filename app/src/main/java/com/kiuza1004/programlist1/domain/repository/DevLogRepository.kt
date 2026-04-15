package com.kiuza1004.programlist1.domain.repository

import com.kiuza1004.programlist1.domain.model.DevLog
import kotlinx.coroutines.flow.Flow

interface DevLogRepository {
    fun getAllLogs(): Flow<List<DevLog>>
    fun getLogsByCategory(category: String): Flow<List<DevLog>>
    fun searchLogs(query: String): Flow<List<DevLog>>
    suspend fun getLogById(id: Long): DevLog?
    suspend fun insertLog(log: DevLog)
    suspend fun updateLog(log: DevLog)
    suspend fun deleteLog(log: DevLog)
}

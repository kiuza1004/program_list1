package com.kiuza1004.programlist1.data.repository

import com.kiuza1004.programlist1.data.local.DevLogDao
import com.kiuza1004.programlist1.data.mapper.toDomain
import com.kiuza1004.programlist1.data.mapper.toEntity
import com.kiuza1004.programlist1.domain.model.DevLog
import com.kiuza1004.programlist1.domain.repository.DevLogRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DevLogRepositoryImpl @Inject constructor(
    private val dao: DevLogDao
) : DevLogRepository {

    override fun getAllLogs(): Flow<List<DevLog>> {
        return dao.getAllLogs().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun getLogsByCategory(category: String): Flow<List<DevLog>> {
        return dao.getLogsByCategory(category).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun searchLogs(query: String): Flow<List<DevLog>> {
        return dao.searchLogs(query).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getLogById(id: Long): DevLog? {
        return dao.getLogById(id)?.toDomain()
    }

    override suspend fun insertLog(log: DevLog) {
        dao.insertLog(log.toEntity())
    }

    override suspend fun updateLog(log: DevLog) {
        dao.updateLog(log.toEntity())
    }

    override suspend fun deleteLog(log: DevLog) {
        dao.deleteLog(log.toEntity())
    }
}

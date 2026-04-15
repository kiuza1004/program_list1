package com.kiuza1004.programlist1.data.mapper

import com.kiuza1004.programlist1.data.local.DevLogEntity
import com.kiuza1004.programlist1.domain.model.DevLog

fun DevLogEntity.toDomain(): DevLog {
    return DevLog(
        id = id,
        title = title,
        content = content,
        category = category,
        status = status,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun DevLog.toEntity(): DevLogEntity {
    return DevLogEntity(
        id = id,
        title = title,
        content = content,
        category = category,
        status = status,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

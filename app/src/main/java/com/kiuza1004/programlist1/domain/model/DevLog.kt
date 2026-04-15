package com.kiuza1004.programlist1.domain.model

data class DevLog(
    val id: Long = 0,
    val title: String,
    val content: String,
    val category: String,
    val status: String,
    val createdAt: Long,
    val updatedAt: Long
)

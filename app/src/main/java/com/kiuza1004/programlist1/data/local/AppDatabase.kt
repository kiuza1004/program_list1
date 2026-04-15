package com.kiuza1004.programlist1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DevLogEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val devLogDao: DevLogDao

    companion object {
        const val DATABASE_NAME = "devlog_db"
    }
}

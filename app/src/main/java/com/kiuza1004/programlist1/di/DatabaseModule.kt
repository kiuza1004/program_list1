package com.kiuza1004.programlist1.di

import android.content.Context
import androidx.room.Room
import com.kiuza1004.programlist1.data.local.AppDatabase
import com.kiuza1004.programlist1.data.local.DevLogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseOf(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideDevLogDao(db: AppDatabase): DevLogDao {
        return db.devLogDao
    }
}

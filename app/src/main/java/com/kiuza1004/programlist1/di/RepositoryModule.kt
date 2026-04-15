package com.kiuza1004.programlist1.di

import com.kiuza1004.programlist1.data.repository.DevLogRepositoryImpl
import com.kiuza1004.programlist1.domain.repository.DevLogRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDevLogRepository(
        devLogRepositoryImpl: DevLogRepositoryImpl
    ): DevLogRepository
}

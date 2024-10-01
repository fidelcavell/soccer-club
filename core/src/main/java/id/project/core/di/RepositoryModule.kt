package id.project.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.project.core.data.source.SoccerClubRepository
import id.project.core.data.source.local.LocalDataSource
import id.project.core.data.source.remote.RemoteDataSource
import id.project.core.domain.repository.ISoccerClubRepository
import id.project.core.utils.AppExecutors
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class, NetworkModule::class])
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource,
        executors: AppExecutors
    ): ISoccerClubRepository = SoccerClubRepository(remoteDataSource, localDataSource, executors)
}
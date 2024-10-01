package id.project.soccerclub.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.project.core.domain.usecase.SoccerClubInteractor
import id.project.core.domain.usecase.SoccerClubUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideSoccerUseCase(soccerClubInteractor: SoccerClubInteractor): SoccerClubUseCase
}
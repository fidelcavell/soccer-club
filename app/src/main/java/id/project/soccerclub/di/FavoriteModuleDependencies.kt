package id.project.soccerclub.di

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.project.core.domain.usecase.SoccerClubUseCase

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun soccerClubUseCase(): SoccerClubUseCase
}
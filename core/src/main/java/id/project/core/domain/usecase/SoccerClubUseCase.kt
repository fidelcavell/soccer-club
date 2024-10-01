package id.project.core.domain.usecase

import id.project.core.data.source.Resource
import id.project.core.domain.model.SoccerClub
import kotlinx.coroutines.flow.Flow

interface SoccerClubUseCase {
    fun getAllSoccerClub() : Flow<Resource<List<SoccerClub>>>

    fun getFavoriteSoccerClub() : Flow<List<SoccerClub>>

    fun updateFavoriteSoccerClub(soccerClub: SoccerClub, isFavorite: Boolean)
}
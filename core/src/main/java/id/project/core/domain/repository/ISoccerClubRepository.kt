package id.project.core.domain.repository

import id.project.core.data.source.Resource
import id.project.core.domain.model.SoccerClub
import kotlinx.coroutines.flow.Flow

interface ISoccerClubRepository {
    fun getAllSoccerClub() : Flow<Resource<List<SoccerClub>>>

    fun getAllFavoriteSoccerClub() : Flow<List<SoccerClub>>

    fun updateFavoriteSoccerClub(soccerClub: SoccerClub, isFavorite: Boolean)
}
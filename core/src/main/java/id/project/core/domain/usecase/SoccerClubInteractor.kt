package id.project.core.domain.usecase

import id.project.core.data.source.Resource
import id.project.core.domain.model.SoccerClub
import id.project.core.domain.repository.ISoccerClubRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SoccerClubInteractor @Inject constructor(private val soccerClubRepository: ISoccerClubRepository) : SoccerClubUseCase {
    override fun getAllSoccerClub(): Flow<Resource<List<SoccerClub>>> = soccerClubRepository.getAllSoccerClub()

    override fun getFavoriteSoccerClub(): Flow<List<SoccerClub>> = soccerClubRepository.getAllFavoriteSoccerClub()

    override fun updateFavoriteSoccerClub(soccerClub: SoccerClub, isFavorite: Boolean) = soccerClubRepository.updateFavoriteSoccerClub(soccerClub, isFavorite)
}
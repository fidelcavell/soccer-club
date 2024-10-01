package id.project.core.data.source.local

import id.project.core.data.source.local.entity.SoccerClubEntity
import id.project.core.data.source.local.room.SoccerClubDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val soccerClubDao: SoccerClubDao) {
    fun getAllSoccerClub(): Flow<List<SoccerClubEntity>> = soccerClubDao.getAllSoccerClub()

    fun getAllFavoriteSoccerClub(): Flow<List<SoccerClubEntity>> = soccerClubDao.getAllFavoriteSoccerClub()

    suspend fun insertSoccerClubs(soccerClubList: List<SoccerClubEntity>) = soccerClubDao.insertSoccerClubs(soccerClubList = soccerClubList)

    fun updateFavoriteSoccerClub(soccerClub: SoccerClubEntity, isFavorite: Boolean) {
        soccerClub.isFavorite = isFavorite
        soccerClubDao.updateFavoriteSoccerClub(soccerClub = soccerClub)
    }
}
package id.project.core.data.source

import id.project.core.data.source.local.LocalDataSource
import id.project.core.data.source.remote.RemoteDataSource
import id.project.core.data.source.remote.network.ApiResponse
import id.project.core.data.source.remote.response.SoccerClubResponse
import id.project.core.domain.model.SoccerClub
import id.project.core.domain.repository.ISoccerClubRepository
import id.project.core.utils.AppExecutors
import id.project.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SoccerClubRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISoccerClubRepository {
    override fun getAllSoccerClub(): Flow<Resource<List<SoccerClub>>> =
        object : NetworkBoundResource<List<SoccerClub>, List<SoccerClubResponse>>() {
            override fun loadFromDB(): Flow<List<SoccerClub>> {
                return localDataSource.getAllSoccerClub().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<SoccerClubResponse>>> =
                remoteDataSource.getAllSoccerClub()

            override suspend fun saveCallResult(data: List<SoccerClubResponse>) {
                val soccerClubList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertSoccerClubs(soccerClubList = soccerClubList)
            }

            override fun shouldFetch(data: List<SoccerClub>?): Boolean = data.isNullOrEmpty()
        }.asFlow()

    override fun getAllFavoriteSoccerClub(): Flow<List<SoccerClub>> {
        return localDataSource.getAllFavoriteSoccerClub().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun updateFavoriteSoccerClub(soccerClub: SoccerClub, isFavorite: Boolean) {
        val soccerClubEntity = DataMapper.mapDomainToEntity(soccerClub)
        appExecutors.diskIO().execute {
            localDataSource.updateFavoriteSoccerClub(
                soccerClub = soccerClubEntity,
                isFavorite = isFavorite
            )
        }
    }
}
package id.project.core.data.source.remote

import id.project.core.data.source.remote.network.ApiResponse
import id.project.core.data.source.remote.network.ApiService
import id.project.core.data.source.remote.response.SoccerClubResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllSoccerClub(): Flow<ApiResponse<List<SoccerClubResponse>>> {
        return flow {
            try {
                val response = apiService.getSoccerClubs()
                val dataArray = response.clubs

                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.clubs))
                } else {
                    emit(ApiResponse.Empty)
                }

            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}
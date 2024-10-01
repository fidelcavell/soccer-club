package id.project.core.data.source.remote.network

import id.project.core.data.source.remote.response.ListSoccerClubResponse
import retrofit2.http.GET

interface ApiService {
    @GET("search_all_teams.php?l=English%20Premier%20League")
    suspend fun getSoccerClubs() : ListSoccerClubResponse
}
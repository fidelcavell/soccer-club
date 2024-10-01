package id.project.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListSoccerClubResponse(
    @field:SerializedName("teams")
    val clubs: List<SoccerClubResponse>
)
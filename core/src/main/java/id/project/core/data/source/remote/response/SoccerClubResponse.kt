package id.project.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SoccerClubResponse(

    @field:SerializedName("idTeam")
    val idTeam: String,

    @field:SerializedName("strTeam")
    val strTeam: String,

    @field:SerializedName("strLocation")
    val strLocation: String,

    @field:SerializedName("strCountry")
    val strCountry: String,

    @field:SerializedName("strDescriptionEN")
    val strDescriptionEN: String,

    @field:SerializedName("strFanart1")
    val strFanArt: String,
)
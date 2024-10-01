package id.project.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SoccerClub(
    var id: Int,
    var idTeam: String,
    var strTeam: String,
    var strLocation: String,
    var strCountry: String,
    var strDescriptionEN: String,
    var strFanArt: String,
    var isFavorite: Boolean
) : Parcelable
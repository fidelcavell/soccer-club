package id.project.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "soccer_club")
data class SoccerClubEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    var idTeam: String,
    var strTeam: String,
    var strLocation: String,
    var strCountry: String,
    var strDescriptionEN: String,
    var strFanArt: String,
    var isFavorite: Boolean = false
) : Parcelable

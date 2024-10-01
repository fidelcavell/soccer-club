package id.project.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.project.core.domain.usecase.SoccerClubUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private val soccerClubUseCase: SoccerClubUseCase) : ViewModel() {
    val favoriteSoccerClub = soccerClubUseCase.getFavoriteSoccerClub().asLiveData()

    fun s() {
        soccerClubUseCase.getFavoriteSoccerClub()
    }
}
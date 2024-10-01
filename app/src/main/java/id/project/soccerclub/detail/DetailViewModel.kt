package id.project.soccerclub.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.project.core.domain.model.SoccerClub
import id.project.core.domain.usecase.SoccerClubUseCase
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val soccerClubUseCase: SoccerClubUseCase) :
    ViewModel() {
    fun updateFavoriteSoccerClub(soccerClub: SoccerClub, isFavorite: Boolean) =
        soccerClubUseCase.updateFavoriteSoccerClub(soccerClub, isFavorite)
}
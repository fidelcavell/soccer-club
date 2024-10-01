package id.project.soccerclub.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import id.project.core.domain.usecase.SoccerClubUseCase
import id.project.core.ui.ThemePreferences
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(soccerClubUseCase: SoccerClubUseCase, themePreferences: ThemePreferences) : ViewModel() {
    val soccerClubList = soccerClubUseCase.getAllSoccerClub().asLiveData()

    val isDarkMode = themePreferences.getThemeSetting().asLiveData()
}
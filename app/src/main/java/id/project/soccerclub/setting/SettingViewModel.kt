package id.project.soccerclub.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.project.core.ui.ThemePreferences
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(private val themePreferences: ThemePreferences) :
    ViewModel() {
    val isDarkMode = themePreferences.getThemeSetting().asLiveData()

    fun switchTheme(isDarkMode: Boolean) {
        viewModelScope.launch {
            themePreferences.saveThemeSetting(isDarkMode = isDarkMode)
        }
    }
}
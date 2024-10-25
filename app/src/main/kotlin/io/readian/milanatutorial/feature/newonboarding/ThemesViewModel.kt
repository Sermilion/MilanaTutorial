package io.readian.milanatutorial.feature.newonboarding

import androidx.lifecycle.ViewModel
import io.readian.milanatutorial.core.update.NewFakeBackendServer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ThemesViewModel @Inject constructor(private val server: NewFakeBackendServer): ViewModel() {

    private val _categories = listOf(
        "Photography", "IT", "Science", "Art", "Design", "Coding",
        "Philosophy", "SJW", "Space", "Nature", "Movies", "Music"
    )
    val categories: List<String> = _categories

    private val _selectedCategory = MutableStateFlow("Science")
    val selectedCategory: StateFlow<String> = _selectedCategory

    fun onCategorySelected(category: String) {
        _selectedCategory.value = category
    }
}

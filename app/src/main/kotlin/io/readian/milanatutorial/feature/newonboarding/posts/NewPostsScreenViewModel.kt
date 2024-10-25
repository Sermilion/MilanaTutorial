package io.readian.milanatutorial.feature.newonboarding.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.milanatutorial.core.update.NewFakeBackendServer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewPostsScreenViewModel @Inject constructor(
    server: NewFakeBackendServer
): ViewModel() {

    private val _posts = MutableStateFlow<List<NewPost>>(emptyList())
    var post = _posts.asStateFlow()

    init {
        viewModelScope.launch {
            _posts.update { server.loadPosts() }
        }
    }
}
package io.readian.milanatutorial.feature.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.milanatutorial.core.FakeBackendServer
import io.readian.milanatutorial.feature.posts.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
  private val fakeBackendServer: FakeBackendServer,
) : ViewModel() {

  val uiState = MutableStateFlow(listOf<Post>())

  init {
    viewModelScope.launch(Dispatchers.IO) {
      uiState.update {
        fakeBackendServer.getPosts()
      }
    }
  }

  fun updatePosts() {
    viewModelScope.launch {
      uiState.update { currentList ->
        val newList = mutableListOf<Post>()

        newList.addAll(currentList)

        newList.add(
          Post(
            id = currentList.size + 1,
            title = "New post",
            body = "This is a new post",
            imageUrl = "https://www.cityam.com/wp-content/uploads/2021/06/McLaren-765-LT-scaled.jpg?w=742",
          )
        )
        newList
      }
    }


    println("Foo: ${uiState.value.size}")
  }
}
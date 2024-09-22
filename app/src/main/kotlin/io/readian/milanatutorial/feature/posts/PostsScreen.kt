package io.readian.milanatutorial.feature.posts

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun PostsScreen(viewModel: PostsViewModel) {

  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  Column {
    uiState.forEach {
      Text(text = it.title)
    }

    Button(onClick = { viewModel.updatePosts() }) {
      Text("Add new post")
    }
  }
}
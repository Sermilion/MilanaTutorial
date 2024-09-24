package io.readian.milanatutorial.feature.posts.model

data class Post(
  val id: Int,
  val title: String,
  val body: String,
  val imageUrl: String,
)
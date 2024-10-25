package io.readian.milanatutorial.feature.newonboarding.posts

data class NewPost(
    val id: Int,
    val source: String,
    val title: String,
    val imageUrl: String,
    val tags: List<String>
)
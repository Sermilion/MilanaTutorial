package io.readian.milanatutorial.core

import io.readian.milanatutorial.feature.onboarding.model.User
import io.readian.milanatutorial.feature.posts.model.Post
import javax.inject.Inject

class FakeBackendServer @Inject constructor() {
  private val users = mutableListOf<User>()

  init {
    users.add(
      User(
        id = 1,
        name = "Milana",
        username = "Milana",
        email = "milana@email.com",
        password = "12345678",
      )
    )
    users.add(
      User(
        id = 2,
        name = "Sermilion",
        username = "Sermilion",
        email = "sermilion@email.com",
        password = "12345678",
      )
    )
  }

  fun login(email: String, password: String): User? {
    return users.find {
      it.email == email && it.password == password
    }
  }

  fun register(username: String, fullName: String, email: String, password: String): Boolean {
    if (users.any { it.email == email }) {
      return false
    }

    users.add(
      User(
        id = users.size + 1,
        name = fullName,
        email = email,
        username = username,
        password = password,
      )
    )
    return true
  }

  fun getPosts(): List<Post> {
    return listOf(
      Post(
        id = 1,
        title = "First post",
        body = "This is the first post",
      ),
      Post(
        id = 2,
        title = "Second post",
        body = "This is the second post",
      ),
      Post(
        id = 3,
        title = "Third post",
        body = "This is the third post",
      ),
      Post(
        id = 4,
        title = "Fourth post",
        body = "This is the fourth post",
      ),
    )
  }
}


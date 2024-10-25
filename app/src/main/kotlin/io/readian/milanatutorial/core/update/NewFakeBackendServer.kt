package io.readian.milanatutorial.core.update

import io.readian.milanatutorial.feature.newonboarding.posts.NewPost
import io.readian.milanatutorial.feature.onboarding.model.User
import javax.inject.Inject

class NewFakeBackendServer @Inject constructor() {
    private val users = mutableListOf<User>()

    val posts = listOf(
        NewPost(
            id = 1,
            source = "blog.discovery",
            title = "Top Places To Travel",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/a/a7/Sleeping_Beauty_Castle_at_Night.jpg",
            tags = listOf("dog", "winter", "disneyland", "travel")
        ),
        NewPost(
            id = 2,
            source = "buzzfeed",
            title = "10 Things You Didn't Know About Cats",
            imageUrl = "https://t4.ftcdn.net/jpg/01/27/27/41/240_F_127274148_BP9Toub9LRvHvICKkRAnw5gctXptUVLV.jpg",
            tags = listOf("cats", "fun", "cute", "adopt")
        )
    )

    suspend fun loadPosts(): List<NewPost> {
        return posts
    }

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
}
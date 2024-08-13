package io.readian.milanatutorial.core

import io.readian.milanatutorial.core.backend.User

class FakeBackendServer {
    private val users = mutableListOf<User>()

    init {
        users.add(User(1, "Milana", "milana@mail.com", "12345678"))
        users.add(User(2, "Sermilion", "sermilion@mail.com", "12345678"))
    }

    fun login(email: String, password: String): User? {
        return users.find { currentUser ->
            currentUser.email == email && currentUser.password == password
        }
    }
}
package io.readian.milanatutorial.coreMial

data class User(val id: Int, val name: String, val username: String, val email: String, val password: String)

class FakeBackendServer {
    private val users = mutableListOf<User>()

    init {
        users.add(User(
            id = 1,
            name = "Milana",
            username = "Milana",
            email = "milana@email.com",
            password = "12345678",
        ))
        users.add(User(
            id = 2,
            name = "Sermilion",
            username = "Sermilion",
            email = "sermilion@email.com",
            password = "12345678",
        ))
    }

    fun login(email: String, password: String): User? {
        return users.find {
            it.email == email && it.password == password
        }
    }

    fun register(username: String, fullName: String, email: String, password: String): Boolean{
        if  (users.any { it.email == email}) {
            return false
        }

        users.add(User(
            id = users.size + 1,
            name = fullName,
            email = email,
            username = username,
            password = password,
        ))
        return true
    }
}

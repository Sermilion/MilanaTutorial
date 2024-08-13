package io.readian.milanatutorial.core.backend

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
)
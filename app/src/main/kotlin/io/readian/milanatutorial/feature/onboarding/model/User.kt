package io.readian.milanatutorial.feature.onboarding.model

data class User(
  val id: Int,
  val name: String,
  val username: String,
  val email: String,
  val password: String
)
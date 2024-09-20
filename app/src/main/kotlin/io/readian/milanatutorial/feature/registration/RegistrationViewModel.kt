package io.readian.milanatutorial.feature.registration

import androidx.lifecycle.ViewModel
import io.readian.milanatutorial.core.FakeBackendServer


class RegistrationViewModel(private val server: FakeBackendServer): ViewModel() {

  fun register(username: String, fullName: String, email: String, password: String): Boolean {
    return server.register(username, fullName, email, password)
  }
}
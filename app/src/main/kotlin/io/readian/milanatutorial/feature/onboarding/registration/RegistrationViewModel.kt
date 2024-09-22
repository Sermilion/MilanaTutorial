package io.readian.milanatutorial.feature.onboarding.registration

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.readian.milanatutorial.core.FakeBackendServer
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val server: FakeBackendServer): ViewModel() {

  fun register(username: String, fullName: String, email: String, password: String): Boolean {
    return server.register(username, fullName, email, password)
  }
}
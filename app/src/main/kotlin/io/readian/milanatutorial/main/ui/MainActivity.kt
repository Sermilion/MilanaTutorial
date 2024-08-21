package io.readian.milanatutorial.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import io.readian.milanatutorial.core.ui.common.LocalActivity
import io.readian.milanatutorial.coreMial.FakeBackendServer
import io.readian.milanatutorial.main.MainActivityViewModel
import io.readian.milanatutorial.feature.registration.RegistrationScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  private val viewModel: MainActivityViewModel by viewModels()
  override fun onCreate(savedInstanceState: Bundle?) {
    val splashScreen = installSplashScreen()
    super.onCreate(savedInstanceState)


    splashScreen.setKeepOnScreenCondition { viewModel.isLoading.value }
    setContent {
      CompositionLocalProvider(LocalActivity provides this) {
        val uiState by viewModel.state.collectAsStateWithLifecycle()
        val server = FakeBackendServer()
        RegistrationScreen(server)
      }
    }
  }
}
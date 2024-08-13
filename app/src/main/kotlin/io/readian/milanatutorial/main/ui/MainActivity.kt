package io.readian.milanatutorial.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.remember
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.readian.milanatutorial.core.FakeBackendServer
import io.readian.milanatutorial.core.ui.MyLabel
import io.readian.milanatutorial.feature.login.LoginScreen

import io.readian.milanatutorial.main.MainActivityViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)


        splashScreen.setKeepOnScreenCondition { viewModel.isLoading.value }
        setContent {
            val uiState by viewModel.state.collectAsStateWithLifecycle()
            val server = FakeBackendServer()
            LoginScreen(server = server)
        }
    }
}

// HOMEWORK:
// username - (2-20 characters)
// full name - (2-50 characters)
// email - (valid email, 2-50 characters, <>@<>.<> )
// password - (8-20 characters, at least one uppercase, one lowercase, one number, one special character)
// confirm password - (must match password)

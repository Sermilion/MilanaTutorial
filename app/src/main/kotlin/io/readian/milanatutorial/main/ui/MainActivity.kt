package io.readian.milanatutorial.main.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

import io.readian.milanatutorial.main.MainActivityViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        val a = 2
        val b = 3

        fun sum(a: Int, b: Int): Int {
            return a + b
        }

        val c = sum(a, b)


        splashScreen.setKeepOnScreenCondition { viewModel.isLoading.value }
        setContent {
            val uiState by viewModel.state.collectAsStateWithLifecycle()

            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Cyan),
                topBar = {
                    TopBar(
                        onBackClicked = {

                        }
                    )
                }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun TopBar(onBackClicked: () -> Unit) {
        CenterAlignedTopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = onBackClicked) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = null,
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
        )
    }
}

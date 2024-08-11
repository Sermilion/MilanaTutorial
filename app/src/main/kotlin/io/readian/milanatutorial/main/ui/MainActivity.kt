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

            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Cyan),
                topBar = {
                    TopBar(
                        onBackClicked = {
                            println("onBackClicked")
                        }
                    )
                }
            ) { innerPadding ->
                var login by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    MyLabel(value = "Login", fontWeight = FontWeight.Bold, fontSize = 32.sp)

                    Spacer(modifier = Modifier.padding(16.dp))

                    OutlinedTextField(
                        value = login,
                        onValueChange = { newValue ->
                            login = newValue
                        }
                    )

                    Spacer(modifier = Modifier.padding(8.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { it ->
                            password = it
                        }
                    )

                    Spacer(modifier = Modifier.padding(5.dp))

                    Button(
                        onClick = {
                            println("Login")
                        },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "Login")
                    }


                    Button(
                        onClick = {
                            println("Forgot password?")
                        },
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(text = "Forgot Password?")
                    }
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

@Composable
fun MyLabel(
    value: String,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit = 16.sp,
    color: Color = Color.Black
) {
    Text(
        text = value,
        fontWeight = fontWeight,
        fontSize = fontSize,
        color = color
    )
}


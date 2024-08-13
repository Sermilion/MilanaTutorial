package io.readian.milanatutorial.feature.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.readian.milanatutorial.core.FakeBackendServer
import io.readian.milanatutorial.core.ui.MyLabel

@Composable
fun LoginScreen(server: FakeBackendServer) {

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
        var passwordVisible by remember { mutableStateOf(false) }
        var showError by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            MyLabel(value = "Login", fontWeight = FontWeight.Bold, fontSize = 32.sp)

            if (showError) {
                MyLabel(
                    value = "Wrong credentials.",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.Red,
                )
            }

            Spacer(modifier = Modifier.padding(32.dp))

            OutlinedTextField(
                value = login,
                label = { Text(text = "Login") },
                onValueChange = { newValue ->
                    login = newValue
                }
            )

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                value = password,
                label = { Text(text = "Password") },
                onValueChange = { it ->
                    password = it
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    PasswordVisibilityIcon(
                        passwordVisible = passwordVisible,
                        onPasswordVisibilityClick = {
                            passwordVisible = !passwordVisible
                        },
                    )
                },
            )

            Spacer(modifier = Modifier.padding(5.dp))

            Button(
                onClick = {
                    val result = server.login(login, password)
                    showError = result == null
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
fun PasswordVisibilityIcon(
    passwordVisible: Boolean,
    modifier: Modifier = Modifier,
    onPasswordVisibilityClick: () -> Unit,
) {
    val image = if (passwordVisible) {
        Icons.Filled.Visibility
    } else {
        Icons.Filled.VisibilityOff
    }

    val description = if (passwordVisible) {
        "Show password"
    } else {
        "Hide password"
    }

    IconButton(
        onClick = onPasswordVisibilityClick,
        modifier = modifier,
    ) {
        Icon(imageVector = image, description)
    }
}

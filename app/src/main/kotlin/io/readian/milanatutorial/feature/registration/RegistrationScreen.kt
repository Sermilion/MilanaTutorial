package io.readian.milanatutorial.feature.registration

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.readian.milanatutorial.core.ui.common.LocalActivity
import io.readian.milanatutorial.coreMial.FakeBackendServer
import io.readian.milanatutorial.feature.login.MyLabel
import io.readian.milanatutorial.feature.login.TopBar

@Composable
fun RegistrationScreen(server: FakeBackendServer) {
    var username by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }

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
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyLabel(value = "Registration", fontWeight = FontWeight.Bold, fontSize = 32.sp)

            Spacer(modifier = Modifier.padding(16.dp))

            RegistrationTextField(
                value = username,
                onValueChange = { username = it },
                label = "Username"
            )

            Spacer(modifier = Modifier.padding(8.dp))

            RegistrationTextField(
                value = fullName,
                onValueChange = { fullName = it },
                label = "Full Name"
            )

            Spacer(modifier = Modifier.padding(8.dp))

            RegistrationTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            RegistrationPasswordField(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                passwordVisibility = passwordVisibility,
                onPasswordVisibilityChange = { passwordVisibility = it }
            )

            Spacer(modifier = Modifier.padding(8.dp))

            RegistrationPasswordField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = "Confirm Password",
                passwordVisibility = confirmPasswordVisibility,
                onPasswordVisibilityChange = { confirmPasswordVisibility = it }
            )

            Spacer(modifier = Modifier.padding(8.dp))

            val context = LocalActivity.current

            Button(
                onClick = {
                    if (password != confirmPassword) {
                        Toast.makeText(context, "Passwords do not match!", Toast.LENGTH_SHORT).show()
                    } else {
                        val isSuccess = server.register(username, fullName, email, password)
                        if (isSuccess) {
                            Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "User already exists!", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Sign Up")
            }
        }
    }
}

@Composable
fun RegistrationTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun RegistrationPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    passwordVisibility: Boolean,
    onPasswordVisibilityChange: (Boolean) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { onPasswordVisibilityChange(!passwordVisibility) }) {
                Icon(
                    imageVector = if (passwordVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                    contentDescription = "Toggle password visibility"
                )
            }
        }
    )
}

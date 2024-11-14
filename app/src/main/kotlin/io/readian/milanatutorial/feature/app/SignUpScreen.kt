package io.readian.milanatutorial.feature.app

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.readian.milanatutorial.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    signUpViewModel: SignUpScreenViewModel = viewModel()
) {
    val username by remember { derivedStateOf { signUpViewModel.username.value } }
    val email by remember { derivedStateOf { signUpViewModel.email.value } }
    val password by remember { derivedStateOf { signUpViewModel.password.value } }
    val confirmPassword by remember { derivedStateOf { signUpViewModel.confirmPassword.value } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(45.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Sign Up",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(45.dp))

        TextField(
            value = username,
            onValueChange = { signUpViewModel.onUsernameChange(it) },
            label = { Text("Username", color = Color(0xFF3B82F6)) },
            placeholder = { Text("Enter your username", color = Color.Gray) },
            textStyle = TextStyle(color = Color.Gray),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF3B82F6),
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color(0xFF3B82F6),
                unfocusedLabelColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = { signUpViewModel.onEmailChange(it) },
            label = { Text("Email", color = Color(0xFF3B82F6)) },
            placeholder = { Text("Enter your email", color = Color.Gray) },
            textStyle = TextStyle(color = Color.Black),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF3B82F6),
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color(0xFF3B82F6),
                unfocusedLabelColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { signUpViewModel.onPasswordChange(it) },
            label = { Text("Password", color = Color(0xFF3B82F6)) },
            placeholder = { Text("Enter your password", color = Color.Gray) },
            textStyle = TextStyle(color = Color.Gray),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF3B82F6),
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color(0xFF3B82F6),
                unfocusedLabelColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = confirmPassword,
            onValueChange = { signUpViewModel.onConfirmPasswordChange(it) },
            label = { Text("Confirm Password", color = Color(0xFF3B82F6)) },
            placeholder = { Text("Re-enter your password", color = Color.Gray) },
            textStyle = TextStyle(color = Color.Gray),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF3B82F6),
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color(0xFF3B82F6),
                unfocusedLabelColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        IconButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.ic_log),
                    contentDescription = "SignUp Button",
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = "Sign Up",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "or sign up with",
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "By signing up you accept the Terms of Service and Privacy Policy",
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}

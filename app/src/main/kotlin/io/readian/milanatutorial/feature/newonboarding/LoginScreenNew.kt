package io.readian.milanatutorial.feature.newonboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.readian.milanatutorial.core.update.NewFakeBackendServer

@Composable
fun LoginScreenNew(server: NewFakeBackendServer)  {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        topBar = {
            TopBar(onBackClicked = { println("onBackClicked") })
        }
    ) { innerPadding ->
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            MyLabel(value = "Log In", fontWeight = FontWeight.Bold, fontSize = 32.sp)

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Email",
                    color = Color.Blue,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                    ),
                    placeholder = { Text(text = "Enter your email") }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Password",
                    color = Color.Blue,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Gray,
                    fontSize = 18.sp
                ),
                placeholder = { Text(text = "Password") }
            )
            Text(
                text = "Forgot Password?",
                color = Color.Blue,
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable { println("Forgot password clicked") }
                    .padding(20.dp)
            )

            Button(
                onClick = { },
                colors = buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Log In")
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
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
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
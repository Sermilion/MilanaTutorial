package io.readian.milanatutorial.feature.newonboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThemesScreen(themesViewModel: ThemesViewModel) {
    val selectedCategory = themesViewModel.selectedCategory.collectAsState().value
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        topBar = {
            TopBar(onBackClicked = { println("onBackClicked") })
            HeaderRow(
                onBackClicked = { println("Back clicked") },
                onSkipClicked = { println("Skip clicked") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                items(themesViewModel.categories) { category ->
                    CategoryItem(
                        category = category,
                        isSelected = selectedCategory == category,
                        onCategoryClick = { themesViewModel.onCategorySelected(category) }
                    )
                }
            }

            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
            ) {
                Text(
                    text = "Next",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun CategoryItem(category: String, isSelected: Boolean, onCategoryClick: () -> Unit) {
    Text(
        text = category,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onCategoryClick)
            .padding(horizontal = 16.dp),
        fontSize = 24.sp,
        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Light,
        color = if (isSelected) Color.Black else Color.Gray
    )
}

@Composable
fun HeaderRow(
    onBackClicked: () -> Unit,
    onSkipClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = " ",
            fontSize = 24.sp,
            modifier = Modifier
                .clickable { onBackClicked() }
        )

        Text(
            text = "Please select your themes",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2563EB)
        )

        Text(
            text = "Skip",
            fontSize = 16.sp,
            color = Color(0xFF2563EB),
            modifier = Modifier.clickable { onSkipClicked() }
        )
    }
}

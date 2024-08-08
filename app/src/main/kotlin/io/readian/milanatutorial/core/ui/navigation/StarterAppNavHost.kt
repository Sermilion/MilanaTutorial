package io.readian.milanatutorial.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun StarterAppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = TODO(),
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        TODO()
    }
}

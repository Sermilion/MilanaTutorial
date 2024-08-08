package io.readian.milanatutorial.core.ui.app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Domain
import androidx.compose.material.icons.filled.House
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.readian.milanatutorial.core.designsystem.icon.Icon
import io.readian.milanatutorial.core.navigation.StarterAppNavigationDestination
import io.readian.milanatutorial.core.ui.navigation.TopLevelDestination
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun rememberStarterAppState(
    navController: NavHostController = rememberNavController(),
): StarterAppState {
    return remember(navController) {
        StarterAppState(navController = navController)
    }
}

@Stable
class StarterAppState(val navController: NavHostController) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val showBottomNavigation: Boolean
        @Composable get() {
            return when (currentDestination?.route) {
                null -> false
                else -> true
            }
        }

    val topLevelDestinations: ImmutableList<TopLevelDestination> = listOfNotNull(
        TopLevelDestination(
            route = TODO(),
            destination = TODO(),
            selectedIcon = Icon.ImageVectorIcon(Icons.Default.Domain),
            iconTextResource = TODO(),
        ),
        TopLevelDestination(
            route = TODO(),
            destination = TODO(),
            selectedIcon = Icon.ImageVectorIcon(Icons.Default.House),
            iconTextResource = TODO(),
        ),
    ).toImmutableList()

    fun navigate(destination: StarterAppNavigationDestination, route: String? = null) {
        if (destination is TopLevelDestination) {
            navController.navigate(route ?: destination.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        } else {
            navController.navigate(route ?: destination.route)
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}

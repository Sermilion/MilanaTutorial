package io.readian.milanatutorial.core.ui.app

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import io.readian.milanatutorial.core.designsystem.component.ReadianBackground
import io.readian.milanatutorial.core.designsystem.theme.StarterAppTheme
import io.readian.milanatutorial.core.ui.navigation.ReadianNavigationBar
import io.readian.milanatutorial.core.ui.navigation.ReadianNavigationBarItem
import io.readian.milanatutorial.core.ui.navigation.StarterAppNavHost
import io.readian.milanatutorial.core.ui.navigation.TopLevelDestination
import io.readian.milanatutorial.core.update.UpdateChecker
import kotlinx.collections.immutable.ImmutableList

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun StarterApp(
    userLogged: Boolean,
    modifier: Modifier = Modifier,
    appState: StarterAppState = rememberStarterAppState(),
) {
    StarterAppTheme {
        ReadianBackground {
            UpdateChecker {
                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(MaterialTheme.colorScheme.background)

                val topLevelDestinations = appState.topLevelDestinations
                Scaffold(
                    modifier = Modifier
                        .systemBarsPadding()
                        .then(modifier),
                    bottomBar = {
                        if (appState.showBottomNavigation) {
                            StarterAppBottomBar(
                                destinations = topLevelDestinations,
                                onNavigateToDestination = appState::navigate,
                                currentDestination = appState.currentDestination,
                            )
                        }
                    },
                ) { innerPadding ->

                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding)
                            .windowInsetsPadding(
                                WindowInsets.safeDrawing.only(
                                    WindowInsetsSides.Vertical,
                                ),
                            ),
                    ) {
                        StarterAppNavHost(
                            navController = appState.navController,
                            startDestination = if (userLogged) {
                                TODO()
                            } else {
                                TODO()
                            },
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StarterAppBottomBar(
    destinations: ImmutableList<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    ReadianNavigationBar(modifier = modifier) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)

            ReadianNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = { destination.selectedIcon },
                label = { Text(stringResource(destination.iconTextResource)) },
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.equals(destination.route) ?: false
    } ?: false

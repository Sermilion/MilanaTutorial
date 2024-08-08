package io.readian.milanatutorial.core.ui.navigation

import androidx.annotation.StringRes
import io.readian.milanatutorial.core.designsystem.icon.Icon
import io.readian.milanatutorial.core.navigation.StarterAppNavigationDestination

data class TopLevelDestination(
    override val route: String,
    override val destination: String,
    val selectedIcon: Icon,
    @StringRes val iconTextResource: Int,
) : StarterAppNavigationDestination

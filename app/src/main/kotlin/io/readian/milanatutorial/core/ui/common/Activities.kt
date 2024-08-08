package io.readian.milanatutorial.core.ui.common

import android.app.Activity
import androidx.compose.runtime.staticCompositionLocalOf

val LocalActivity = staticCompositionLocalOf<Activity> {
    error("CompositionLocal LocalActivity not present")
}

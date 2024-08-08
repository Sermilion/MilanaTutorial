package io.readian.milanatutorial.core.update

import androidx.compose.runtime.Composable
import se.warting.inappupdate.compose.RequireLatestVersion

@Composable
fun UpdateChecker(content: @Composable () -> Unit) = RequireLatestVersion(content)

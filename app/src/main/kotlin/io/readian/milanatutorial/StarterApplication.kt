package io.readian.milanatutorial

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class StarterApplication :
    Application(),
    LifecycleEventObserver {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Unit
    }
}

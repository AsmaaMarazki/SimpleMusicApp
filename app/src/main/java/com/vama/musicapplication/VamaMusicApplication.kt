package com.vama.musicapplication

import android.app.Application
import com.vama.network.NetworkConfiguration
import com.vama.network.NetworkManagerConfigurations
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class VamaMusicApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setUpAppNetworkConfigurations()

    }

    private fun setUpAppNetworkConfigurations() {
        NetworkManagerConfigurations.setUp(
            NetworkConfiguration(
                isDebug = BuildConfig.DEBUG,
                baseUrl = BuildConfig.BASE_URL
            )
        )
    }
}
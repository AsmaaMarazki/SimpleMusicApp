package com.vama.musicapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.vama.musicapplication.navigation.VamaMusicNavHost
import com.vama.musicapplication.ui.theme.MusicApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicAppMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicApplicationTheme {
                VamaMusicNavHost()
            }
        }
    }
}
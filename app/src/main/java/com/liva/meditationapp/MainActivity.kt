package com.liva.meditationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.liva.meditationapp.login.LoginScreen
import com.liva.meditationapp.login.LoginViewModel
import com.liva.meditationapp.mainpage.MeditationApp
import com.liva.meditationapp.navigation.AppNavigation
import com.liva.meditationapp.settings.SettingsScreen
import com.liva.meditationapp.ui.theme.MeditationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}
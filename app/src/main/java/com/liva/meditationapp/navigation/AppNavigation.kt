package com.liva.meditationapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.liva.meditationapp.adhdmeditation.AdhdApp
import com.liva.meditationapp.anxietymeditation.AnxietyApp
import com.liva.meditationapp.focusingmeditation.FocusingApp
import com.liva.meditationapp.login.LoginScreen
import com.liva.meditationapp.login.LoginViewModel
import com.liva.meditationapp.mainpage.MeditationApp
import com.liva.meditationapp.settings.SettingsScreen
import com.liva.meditationapp.sleepingmeditation.SleepingApp
import com.liva.meditationapp.stressmeditation.StressApp
import com.liva.meditationapp.studyingmeditation.StudyingApp

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route) {
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(viewModel = LoginViewModel(), navController, loginEnable = true)
        }
        composable(route = AppScreens.MainScreen.route) {
            MeditationApp(navController)
        }
        composable(route = AppScreens.SettingsScreen.route) {
            SettingsScreen(navController)
        }
        composable(route = AppScreens.ADHDScreen.route) {
            AdhdApp(navController)
        }
        composable(route = AppScreens.AnxietyScreen.route) {
            AnxietyApp(navController)
        }
        composable(route = AppScreens.FocusingScreen.route) {
            FocusingApp(navController)
        }
        composable(route = AppScreens.SleepingScreen.route) {
            SleepingApp(navController)
        }
        composable(route = AppScreens.StressScreen.route) {
            StressApp(navController)
        }
        composable(route = AppScreens.StudyingScreen.route) {
            StudyingApp(navController)
        }
    }
}

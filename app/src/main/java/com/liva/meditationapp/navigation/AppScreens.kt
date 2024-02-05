package com.liva.meditationapp.navigation

sealed class AppScreens(val route:String){
    object LoginScreen: AppScreens("Login_Screen")
    object MainScreen: AppScreens("Main_Screen")
    object SettingsScreen: AppScreens("Settings_Screen")
    object ADHDScreen: AppScreens("ADHD_Screen")
    object AnxietyScreen: AppScreens("Anxiety_Screen")
    object FocusingScreen: AppScreens("Focusing_Screen")
    object SleepingScreen: AppScreens("Sleeping_Screen")
    object StressScreen: AppScreens("Stress_Screen")
    object StudyingScreen: AppScreens("Studying_Screen")
}
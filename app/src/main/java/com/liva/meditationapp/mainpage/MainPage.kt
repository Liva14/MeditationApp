package com.liva.meditationapp.mainpage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.liva.meditationapp.adhdmeditation.AdhdPreview
import com.liva.meditationapp.anxietymeditation.AnxietyPreview
import com.liva.meditationapp.focusingmeditation.FocusingPreview
import com.liva.meditationapp.scaffold.MyBottomNavigation
import com.liva.meditationapp.scaffold.MyTopAppBar
import com.liva.meditationapp.sleepingmeditation.SleepingPreview
import com.liva.meditationapp.stressmeditation.StressPreview
import com.liva.meditationapp.studyingmeditation.StudyingPreview

@Preview
@Composable
fun MeditationApp() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            MyTopAppBar()
        },
        bottomBar = {
            MyBottomNavigation()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Meditation(text = "Meditation")
            MeditationText(text = "Meditation is a practice of mindfulness, or focusing the mind on a particular object, thought, or activity to train attention and awareness, and achieve a mentally clear and emotionally calm and stable state.\n\nIn this app you will receive tips for different types of meditations.")
            MeditationExercises(navController = navController)
        }
    }
}

@Composable
fun Meditation(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            color = Color.Black
        )
    }
}

@Composable
fun MeditationText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Normal,
        fontSize = 19.sp,
        color = Color.Black,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun MeditationExercises(navController: NavController) {
    val exercises = listOf(
        "Sleeping",
        "Anxiety",
        "Stress",
        "Focusing",
        "Studying",
        "ADHD"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        exercises.chunked(2).forEachIndexed { rowIndex, rowExercises ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = if (rowIndex > 0) 16.dp else 0.dp)
            ) {
                rowExercises.forEach { exercise ->
                    Button(
                        onClick = {
                            when (exercise) {
                                "Sleeping" -> navController.navigate("sleeping_exercise")
                                "Anxiety" -> navController.navigate("anxiety_exercise")
                                "Stress" -> navController.navigate("stress_exercise")
                                "Focusing" -> navController.navigate("focusing_exercise")
                                "Studying" -> navController.navigate("studying_exercise")
                                "ADHD" -> navController.navigate("adhd_exercise")
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = if (rowExercises.last() == exercise) 0.dp else 16.dp)
                    ) {
                        Text(
                            text = exercise,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "meditation_exercises") {
        composable("meditation_exercises") {
            MeditationExercises(navController)
        }
        composable("sleeping_exercise") {
            SleepingPreview(n)
        }
        composable("anxiety_exercise") {
            AnxietyPreview()
        }
        composable("stress_exercise") {
            StressPreview()
        }
        composable("focusing_exercise") {
            FocusingPreview()
        }
        composable("studying_exercise") {
            StudyingPreview()
        }
        composable("adhd_exercise") {
            AdhdPreview()
        }
    }
}
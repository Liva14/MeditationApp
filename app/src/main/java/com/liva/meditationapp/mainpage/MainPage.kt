package com.liva.meditationapp.mainpage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.liva.meditationapp.navigation.AppScreens
import com.liva.meditationapp.scaffold.MyBottomNavigation
import com.liva.meditationapp.scaffold.MyNavigationDrawer
import com.liva.meditationapp.scaffold.MyTopAppBar
import kotlinx.coroutines.launch

@Composable
fun MeditationApp(navController: NavController) {
    val scope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                MyNavigationDrawer { scope.launch { drawerState.close() } }
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar() {
                    scope.launch { drawerState.open() }
                }
            },
            bottomBar = {
                MyBottomNavigation(navController)
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Meditation(text = "Meditation")
                MeditationText(text = "Meditation is an ancient practice that dates back thousands of years. Despite its age, this practice is common worldwide because it has benefits for brain health and overall well-being. With the help of modern technology, researchers continue to expand their understanding of how meditation helps people and why it works.")
                MeditationExercises(navController)
            }
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
        )
    }
}

@Composable
fun MeditationText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Normal,
        fontSize = 19.sp,
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
                            when (exercise){
                                "Sleeping" -> navController.navigate(route = AppScreens.SleepingScreen.route)
                                "Anxiety" -> navController.navigate(route = AppScreens.AnxietyScreen.route)
                                "Stress" -> navController.navigate(route = AppScreens.StressScreen.route)
                                "Focusing" -> navController.navigate(route = AppScreens.FocusingScreen.route)
                                "Studying" -> navController.navigate(route = AppScreens.StudyingScreen.route)
                                "ADHD" -> navController.navigate(route = AppScreens.ADHDScreen.route)
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
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
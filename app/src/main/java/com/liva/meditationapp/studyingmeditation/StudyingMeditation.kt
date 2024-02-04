package com.liva.meditationapp.studyingmeditation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liva.meditationapp.R
import com.liva.meditationapp.scaffold.MyBottomNavigation
import com.liva.meditationapp.scaffold.MyTopAppBar

@Composable
fun MeditationType(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Color.Black,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun LoremIpsumText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.Black,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun BackgroundImage() {
    Image(
        modifier = Modifier.size(200.dp),
        painter = painterResource(
            id = R.drawable.studying
        ),
        contentDescription = "Logo"
    )

}

@Composable
fun StudyingApp() {
    Scaffold(
        topBar = {
            MyTopAppBar()
        },
        bottomBar = {
            MyBottomNavigation()
        }
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            MeditationType("Studying Meditation")
            BackgroundImage()
            LoremIpsumText(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop Aldus software like including versions of Lorem Ipsum publishing PageMaker"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudyingPreview() {
    StudyingApp()
}
package com.liva.meditationapp.stressmeditation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.platform.LocalUriHandler
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
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun LoremIpsumText() {
    val uriHandler = LocalUriHandler.current
    val link = "https://www.piedmont.org/living-real-change/5-meditation-tips-for-stressful-situations"
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.dp)) {
        Column {
            Text(
                text = "\nKeep your cool in stressful situations by practicing meditation techniques wherever you are. Dennis Buttimer, M.Ed, CEAP, RYT, CHC, a life and wellness coach at Cancer Wellness, shares how you can enjoy the benefits of meditation on the go.",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "\n1. Mindfulness Meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Practice mindfulness as you make your coffee or tea in the morning. Notice each action you take as you prepare your beverage, the shape and details of your mug, as well as the warmth and flavor of your drink.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n2. Deep breathing",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "To practice deep breathing: Inhale through your nose, filling up your chest and belly with air. Breathe out through your nose or mouth, gently squeezing the stomach to the spine until all the air is gone. Breathe in for three counts and out for three counts. Repeat as often as needed.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n3. Total body scan",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "A quick body scan can help relax the body. In your mind, bring awareness to every part of your body. Think about your toes, lower legs, knees, upper legs and so on. Systematically go through each part of the body. Imagine breathing into each area.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n4. View your racing thoughts objectively",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "'The mind is a tricky thing,' says Buttimer. 'You can't believe everything it's telling you. We all have impulsive thoughts and can slip into certain patterns or beliefs'. If your mind is jumping all over the place, objectify it and pretend you are simply an observer of your thoughts, he says. 'You're not the waterfall — you're watching it', says Buttimer.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n5. Gratitude",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "When you are in a stressful situation, think of three things for which you are grateful or ask yourself, \"What might this difficult circumstance be trying to teach me?\" Perhaps it will help you become more patient, calm or accepting of yourself or others.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "More info here",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .clickable { uriHandler.openUri(link) }
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun BackgroundImage() {
    Image(
        modifier = Modifier.size(200.dp),
        painter = painterResource(
            id = R.drawable.sress
        ),
        contentDescription = "Logo"
    )

}

@Composable
fun StressApp() {
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
            MeditationType("Stress Meditation")
            BackgroundImage()
            LoremIpsumText()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StressPreview() {
    StressApp()
}
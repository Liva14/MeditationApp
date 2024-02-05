package com.liva.meditationapp.studyingmeditation

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
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.liva.meditationapp.R
import com.liva.meditationapp.scaffold.MyBottomNavigation
import com.liva.meditationapp.scaffold.MyNavigationDrawer
import com.liva.meditationapp.scaffold.MyTopAppBar
import kotlinx.coroutines.launch

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
    val link = "https://www.hindustantimes.com/lifestyle/health/5-best-meditation-techniques-to-increase-productivity-among-students-101677222371911.html"
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.dp)) {
        Column {
            Text(
                text = "\nEstamos atravesando un entorno muy estresante con todo lo que sucede en el mundo. Los estudiantes de escuelas y universidades parecen tener poco tiempo para respirar aire fresco y oler las rosas. Estas son algunas técnicas de meditación que pueden ayudar a uno a alcanzar un estado de fluidez, pensar con claridad y mantenerse concentrado mientras estudia.",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "\n1. Counting breaths",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "It is one of the best meditations to reduce anxiety and get better sleep, and it is great for beginners! It is also one of the easiest ways to meditate, and you can do it anywhere. To do this, count your breaths at the end of every exhale until you arrive at 10. Once you're at 10, start over again. Even though it is basic, you may still find this challenging as a beginner. But as you progress, you will see how your mental concentration will improve, and it is also a great meditation technique to induce sleep.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n2. Mindfulness meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "This meditation is effective for finding focus and releasing stress. Mindfulness with breathing involves paying close attention to your breath and observing your feelings, sensations, and thoughts without judging them. Several studies have shown how mindfulness is highly beneficial in improving your focus. This helps you become less impulsive with your reactions.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n3. Loving-kindness or metta meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Metta meditation focuses on letting go of anger and frustration, increasing compassion and positivity. It is also a great meditation for solving personal conflicts. Contrary to popular belief that meditation is mostly sitting in silence and working on your breathing techniques, loving-kindness meditation is an active form in which you focus more on sending good thoughts and goodwill. Positive thoughts help improve the self-confidence and productivity needed for young minds.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n4. Mantra meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "This meditation helps foster manifestation, gratitude, and self-love. Mantra is a useful tool to reconnect and find peace within. A mantra is a sentence that you repeat over and over again. It is rooted in the yoga tradition, but you can also pick the mantra that suits your intention. You can start with a fundamental mantra of \" Soham\" or even \"OM\" to get into the practice. These affirmations go a long way in boosting focus and unlocking immense psychological potential for better focus in students.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n5. Body scan meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "It helps in pain management, grounding, and reducing stress. This form of meditation focuses on every physical sensation in your body that requires you to give attention to every inch of your body. It lets you be aware of yourself and how you feel in your body, which relates to your emotional state. Growing up under stress can be hugely detrimental to personality building in the formative years. So, body scan meditation is one of the best techniques to help overcome pain and stress allowing youngsters to feel at ease with themselves and sleep better for increased focus.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "More info here",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.clickable { uriHandler.openUri(link) }.align(Alignment.CenterHorizontally)
            )
        }
    }
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
fun StudyingApp(navController: NavController) {
    val scope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                MyNavigationDrawer{ scope.launch { drawerState.close() } }
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
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                MeditationType("Studying Meditation")
                BackgroundImage()
                LoremIpsumText()
            }
        }
    }
}
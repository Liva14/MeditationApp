package com.liva.meditationapp.sleepingmeditation

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
    val link = "https://puffy.com/blogs/wellness/5-sleep-meditation-techniques-to-calm-your-mind-sleep-better"
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.dp)) {
        Column {
            Text(
                text = "\nSleep meditation is a relaxation technique that can help you fall asleep faster and stay asleep longer. It’s often likened to a natural sleep aid because of its ability to improve the overall quality of sleep. On some days, sleeplessness and nighttime anxiety are unavoidable. If you’ve gone straight to bed after a stressful day, then you’ve likely experienced that it takes longer to fall asleep because your thoughts are keeping you up. Practicing mindfulness is known to reduce stress and anxiety, making it an effective method for keeping the barrage of worrisome thoughts at bay. The goal of bedtime meditation is to clear your mind so that it’s prepped for rest.",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "\n1. Visualization",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Practicing visualization means that you have complete control to imagine any scenario that puts you at ease, whether that’s a serene lake, waterfalls, the beach, or the mountains. The only major thing you need to do is pay close attention to as many details in your scenery as you can. For instance, if you’re imagining yourself lounging by a lake, take note of the water, the plants around you, and any sounds you hear.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n2. Mindful breathing",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Before you’re ready to go to bed, just play some soothing sleep meditation music, which can be effective at reducing stress and lulling you to sleep. The best part is there are several meditation music playlists available on YouTube, so you can pick one that works best for you.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n3. Relaxing body scan",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "The first step for trying this technique is simply getting cozy. Then, make an effort to focus on every part of your body. Start with your head, then make your way down until you reach your toes. This can help you alleviate any tension you’re holding in your body, but if you want to doze off even faster, make a conscious effort to relax every part of your body as you scan it.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n4. Reflective meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Bothersome thoughts keeping you up at night? The goal of reflective meditation is to ask yourself a question and look within yourself. The question can be anything, but ideally, it should trigger a positive response. For instance, you could ask yourself, “What was the nicest thing someone did for me today?” When you discover an answer to your question, try and focus on the feeling that arises and leverage that emotion to soothe your mind.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n5. Sleep meditation music",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Before you’re ready to go to bed, just play some soothing sleep meditation music, which can be effective at reducing stress and lulling you to sleep. The best part is there are several meditation music playlists available on YouTube, so you can pick one that works best for you.\n",
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
            id = R.drawable.sleeping
        ),
        contentDescription = "Logo"
    )

}

@Composable
fun SleepingApp(navController: NavController) {
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
                MeditationType("Sleeping Meditation")
                BackgroundImage()
                LoremIpsumText()
            }
        }
    }
}
package com.liva.meditationapp.anxietymeditation

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
    val link = "https://www.betterhelp.com/advice/anxiety/30-meditation-techniques-for-anxiety/"
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.dp)) {
        Column {
            Text(
                text = "\nAnxiety disorders such as social anxiety disorder, panic disorder, or generalized anxiety disorder are statistically noted to be among some of the most common mental health conditions in the world, according to Mental Health America. However, alongside or independently of therapy or other related strategies, meditation has been suggested to be a helpful way for many to mitigate the symptoms one may experience with anxiety disorders. ",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "\n1. Shikantaza",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Shikantaza, for many, is a type of presence meditation. In this type of meditation for anxiety, you may not focus on anything at all. Rather, you may choose to clear your mind of conscious thought and remain mindful only to what you feel in the present moment, allowing it to pass by you.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n2. Vipassana",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "For many, the goal of Vipassana meditation is to gain insight and think more clearly. You may start with breath work, remaining mindful of the bodily sensations that can happen as you breathe. As you begin to notice other sounds and sensations, you may notice them as a secondary focus, moving back to your primary focus.This practice can allow you to notice stimuli and remain mindful while decreasing excessive or cyclical thoughts.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n3. Mantras",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "For many, a mantra is simply a word or syllable to focus on while practicing meditation. You may choose to use it separately from meditation (such as an affirmation), or alongside your meditative practice. Mantras have been associated with improvements in those with anxiety disorder in recent studies. To practice mantra meditation, you may choose to sit quietly and repeat the mantra, either as a thought or as a whispered sound.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n4. Qigong meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Qigong meditation is closely associated with the martial arts. The practice typically consists of dynamic movements done in a meditative way, which may cause you to focus on specific movements and mindfulness instead of anxiety disorder-related symptoms.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n5. Body Scans",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "For many, the purpose of a body scan is to relax your body and bring you to a more mindful state. The meditative process looks different for everyone. You may choose to start with quiet instrumental music, sat or stood in a comfortable position. You may then be requested to feel or focus on each part of your body, separately relaxing it as much as possible. \n",
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
            id = R.drawable.anxiety
        ),
        contentDescription = "Logo"
    )

}

@Composable
fun AnxietyApp() {
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
                MeditationType("Anxiety Meditation")
                BackgroundImage()
                LoremIpsumText()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnxietyPreview() {
    AnxietyApp()
}
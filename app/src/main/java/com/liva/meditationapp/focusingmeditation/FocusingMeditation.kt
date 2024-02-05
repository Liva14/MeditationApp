package com.liva.meditationapp.focusingmeditation

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
    val link = "https://meditationitems.com/5-best-meditation-for-concentration/"
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.dp)) {
        Column {
            Text(
                text = "\nConcentration is a valuable skill in our fast-paced world, allowing us to focus on tasks, enhance productivity, and find inner calm. However, with distractions constantly vying for our attention, maintaining concentration can be challenging. Fortunately, meditation offers a powerful solution to sharpen our focus and improve concentration. In this article, we will explore five of the best meditations to enhance concentration and provide step-by-step instructions on how to practice them effectively.",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "\n1. Mindfulness Meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "To practice mindfulness meditation, find a quiet and comfortable space. Sit in a relaxed position and close your eyes. Begin by focusing on your breath, observing each inhalation and exhalation. Whenever your mind starts to wander, gently bring your attention back to your breath. Continue this practice for a few minutes, gradually increasing the duration as you progress.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n2. Loving-Kindness Meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "To begin loving-kindness meditation, sit comfortably and close your eyes. Take a few deep breaths, allowing your body and mind to relax. Now, visualize someone you love unconditionally and silently repeat phrases like, “May you be happy, may you be healthy, may you live with ease.” Gradually expand these wishes to include yourself, loved ones, acquaintances, and even difficult individuals. Practice this meditation for about 10-15 minutes daily to enhance concentration and foster a compassionate mindset.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n3. Transcendental Meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "To practice TM, sit comfortably with your eyes closed. Choose a mantra that resonates with you and silently repeat it in your mind. As thoughts arise, gently bring your focus back to the mantra. Practice TM for about 20 minutes, ideally twice a day. With regular practice, TM can enhance concentration and promote a sense of inner peace.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n4. Zen Meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "To begin Zen meditation, find a quiet place and assume a comfortable seated position. Close your eyes partially and direct your gaze downward. Take slow, deep breaths, and focus your attention on the sensation of breath entering and leaving your body. As thoughts arise, acknowledge them without getting caught up in them and gently return your attention to the breath. Practice this meditation for 15-20 minutes daily to enhance concentration and clarity of mind.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n5. Guided Visualization Meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "To begin guided visualization meditation, find a quiet and comfortable space. Close your eyes and take a few deep breaths to relax. Then, imagine yourself in a peaceful and serene location, such as a beach or a forest. Engage your senses by visualizing the sights, sounds, smells, and textures of this place. Allow yourself to immerse fully in the experience, letting go of any distractions. Practice this meditation for 10-15 minutes daily to boost concentration and foster a sense of calm.\n",
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
            id = R.drawable.focusing
        ),
        contentDescription = "Logo"
    )

}
@Preview
@Composable
fun FocusingApp(navController: NavController) {
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
                MeditationType("Focusing Meditation")
                BackgroundImage()
                LoremIpsumText()
            }
        }
    }
}
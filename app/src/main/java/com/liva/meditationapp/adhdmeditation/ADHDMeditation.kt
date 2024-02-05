package com.liva.meditationapp.adhdmeditation

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
import androidx.compose.ui.graphics.Color
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
    val link = "https://www.choosingtherapy.com/meditation-for-adhd/"
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 10.dp)) {
        Column {
            Text(
                text = "\nThere are a variety of meditation techniques that an individual with ADHD can try. Different styles may work better for one person, but not another. It is worth trying out different approaches to find which one(s) work best for you.",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "\n1. Mindfulness Meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Mindfulness meditation is about intentionally focusing on the present moment, as well as noticing what you are experiencing. This is done by dedicating a certain amount of time to practice and create a mind-body connection by acknowledging your thoughts, emotions, and physical presence.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n2. Breathwork",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Breathwork may be incorporated into yoga practices or used on its own. Practicing this can help improve certain ADHD symptoms such as mental clarity, focus, and concentration, as it promotes relaxation and calm.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n3. Mantra Meditation",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Mantra meditation is practiced by incorporating mantras or certain phrases into a typical meditation practice. This cultivates focus which can be helpful for those with inattentive ADHD. Mantra meditation can be done in a variety of settings, and performed while sitting, laying down, standing, or walking. \n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n4. Body Scan",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "A body scan can be done at any point in the day or while meditating. There are guided body scan meditations available, or you can choose a method that works best for you. A body scan can be beneficial, as it creates a mind-body connection and promotes taking time to check in with yourself.\n",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "\n5. Grounding",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Grounding falls into the category of mindfulness, and can assist a person in becoming more present and aware of what they are thinking and feeling within a moment. Grounding techniques can include a number of approaches, including meditation; describing objects around you; using your five senses; creating a safe space in your mind through guided imagery; visualizing your anxiety; and using affirmations.\n",
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
            id = R.drawable.adhd
        ),
        contentDescription = "Logo"
    )

}

@Composable
fun AdhdApp() {
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
            MeditationType("ADHD Meditation")
            BackgroundImage()
            LoremIpsumText()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdhdPreview() {
    AdhdApp()
}
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.liva.meditationapp.scaffold.MyBottomNavigation
import com.liva.meditationapp.scaffold.MyTopAppBar

@Composable
fun MyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)) {
            Column {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About",
                    Modifier
                        .fillMaxWidth()
                        .height(100.dp))
                Text(
                    text = "This application is made for non-profit educational purposes.",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Creator:",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "Javier Linares Ivañez\n",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Contact: ",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "javilinaresivanez@gmail.com",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Text(
                text = "All rights reserved 2024",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}

@Preview
@Composable
fun MyAppPreview() {
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
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            MyApp()
        }
    }
}
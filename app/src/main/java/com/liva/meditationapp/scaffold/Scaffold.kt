package com.liva.meditationapp.scaffold

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.liva.meditationapp.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickDrawer:() -> Unit) {
    TopAppBar(
        title = { Text("MediAPP", color = Color.White) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF649AF8)),
        actions = {
            IconButton(onClick = {onClickDrawer()}) {
                Icon(
                    Icons.Outlined.Info,
                    contentDescription = "About",
                    tint = Color.White
                )
            }
        }
    )
}
@Composable
fun MyBottomNavigation(navController: NavController) {
    var index: Int by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(
        contentColor = Color.White,
        containerColor = Color(0xFF649AF8)
    ) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { navController.navigate(route = AppScreens.MainScreen.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Color(0xFF0A157A)
                )
            },
            label = { Text("Home", color = Color.White) }
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = { navController.navigate(route = AppScreens.SettingsScreen.route) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color(0xFF0A157A),
                )
            },
            label = { Text("Settings", color = Color.White) }
        )
    }
}
@Composable
fun MyNavigationDrawer(onCloseDrawer: () -> Unit) {
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
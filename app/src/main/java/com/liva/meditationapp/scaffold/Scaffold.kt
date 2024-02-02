package com.liva.meditationapp.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text("MediAPP", color = Color.White) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF649AF8)),
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Desc",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Default.Info,
                    contentDescription = "About",
                    tint = Color.White
                )
            }
        }
    )
}
@Preview
@Composable
fun MyBottomNavigation() {
    var index: Int by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(
        contentColor = Color.White,
        containerColor = Color(0xFF649AF8)
    ) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { index = 0 },
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
            onClick = { index = 2 },
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
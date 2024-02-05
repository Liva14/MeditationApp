package com.liva.meditationapp.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.liva.meditationapp.scaffold.MyBottomNavigation
import com.liva.meditationapp.scaffold.MyNavigationDrawer
import com.liva.meditationapp.scaffold.MyTopAppBar
import kotlinx.coroutines.launch


@Composable
fun SettingsScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                MyNavigationDrawer { scope.launch { drawerState.close() } }
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
                Settings()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings() {
    val checkedState = remember { mutableStateOf(false) }
    val sliderPosition = remember { mutableStateOf(0.5f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Dark Mode",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Switch(
            checked = checkedState.value,
            onCheckedChange = { isChecked ->
                checkedState.value = isChecked
            }
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "Text Size",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Slider(
            value = sliderPosition.value,
            onValueChange = { newValue ->
                sliderPosition.value = newValue
            },
            modifier = Modifier.padding(8.dp),
            valueRange = 0f..1f,
            steps = 0,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Visual only, no functionality.",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}



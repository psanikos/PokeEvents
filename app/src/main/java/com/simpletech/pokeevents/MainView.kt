package com.simpletech.pokeevents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.simpletech.pokeevents.home.composables.PokeBottomNavigationBar
import com.simpletech.pokeevents.home.composables.PokeNavigationRail
import com.simpletech.pokeevents.home.composables.PokeTopBar
import com.simpletech.pokeevents.navigation.GraphTargets
import com.simpletech.pokeevents.navigation.tabGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(
    navController: NavHostController,
    windowSizeClass: WindowSizeClass
) {
    val tabController = rememberNavController()
    val showBottomBar = windowSizeClass.widthSizeClass != WindowWidthSizeClass.Expanded

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                PokeBottomNavigationBar(controller = tabController)
            }
        },
        topBar = {
            PokeTopBar(controller = navController)
        }
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            if (!showBottomBar) {
                PokeNavigationRail(controller = tabController)
            }
            NavHost(
                navController = tabController,
                startDestination = GraphTargets.Tabs.routes,
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                tabGraph(navController)
            }
        }
    }

}
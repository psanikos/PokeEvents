package com.simpletech.pokeevents

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.simpletech.pokeevents.navigation.GraphTargets
import com.simpletech.pokeevents.navigation.NavigationTarget
import com.simpletech.pokeevents.navigation.mainGraph

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = GraphTargets.Main.routes,
        builder = {
            mainGraph(navController)
        })
}
package com.simpletech.pokeevents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.simpletech.pokeevents.home.composables.NotImplementedView
import com.simpletech.pokeevents.navigation.BottomNavigationTarget
import com.simpletech.pokeevents.navigation.GraphTargets
import com.simpletech.pokeevents.navigation.NavigationTarget
import com.simpletech.pokeevents.navigation.mainGraph
import com.simpletech.pokeevents.navigation.tabGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(
    navController: NavHostController
) {
    val tabTargets = listOf(
        BottomNavigationTarget.Home,
        BottomNavigationTarget.Search,
        BottomNavigationTarget.Tickets
    )
    val tabController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar {
                val navBackStackEntry by tabController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                tabTargets.forEach { screen ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            tabController.navigate(screen.route) {
                                popUpTo(tabController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(text = screen.title) },
                        icon = {

                        }
                    )
                }
            }
        }
    ) {
        NavHost(
            navController = tabController,
            startDestination = GraphTargets.Tabs.routes,
            modifier = Modifier.padding(it)
        ) {
            tabGraph(navController)
        }
    }
}
package com.simpletech.pokeevents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.simpletech.pokeevents.home.composables.PokeTopBar
import com.simpletech.pokeevents.navigation.BottomNavigationTarget
import com.simpletech.pokeevents.navigation.GraphTargets
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
            Column(
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Divider(
                    thickness = 2.dp,
                    color = MaterialTheme.colorScheme.primaryContainer
                )
                BottomAppBar(
                    tonalElevation = 0.dp,
                    containerColor = MaterialTheme.colorScheme.background,
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .height(72.dp)

                ) {
                    val navBackStackEntry by tabController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    tabTargets.forEach { screen ->
                        val isSelected =
                            currentDestination?.hierarchy?.any { it.route == screen.route } == true
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                tabController.navigate(screen.route) {
                                    popUpTo(tabController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            label = {
                                Text(
                                    text = screen.title,
                                    style = TextStyle(
                                        fontSize = 8.sp,
                                        lineHeight = 10.sp,
                                        fontWeight = FontWeight(500),
                                        textAlign = TextAlign.Center,
                                        letterSpacing = 0.8.sp,
                                    )
                                )
                            },
                            icon = {
                                Image(
                                    painter = painterResource(id = screen.image),
                                    contentDescription = "image description",
                                    contentScale = ContentScale.Fit,
                                    colorFilter = ColorFilter.tint(
                                        color = if (isSelected) MaterialTheme.colorScheme.primary else
                                            MaterialTheme.colorScheme.onSecondary
                                    ),
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                                unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                                indicatorColor = MaterialTheme.colorScheme.background
                            )
                        )

                    }
                }
            }
        },
        topBar = {
            PokeTopBar()
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

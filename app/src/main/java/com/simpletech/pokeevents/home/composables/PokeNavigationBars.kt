package com.simpletech.pokeevents.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.simpletech.pokeevents.navigation.BottomNavigationTarget


@Composable
fun PokeBottomNavigationBar(
    controller: NavHostController
) {
    val tabTargets = listOf(
        BottomNavigationTarget.Home,
        BottomNavigationTarget.Search,
        BottomNavigationTarget.Tickets
    )
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
            val navBackStackEntry by controller.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            tabTargets.forEach { screen ->
                val isSelected =
                    currentDestination?.hierarchy?.any { it.route == screen.route } == true
                NavigationBarItem(
                    selected = isSelected,
                    onClick = {
                        controller.navigate(screen.route) {
                            popUpTo(controller.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    label = {
                        Text(
                            text = stringResource(id = screen.title),
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
}

@Composable
fun PokeNavigationRail(
    controller: NavHostController
) {
    val tabTargets = listOf(
        BottomNavigationTarget.Home,
        BottomNavigationTarget.Search,
        BottomNavigationTarget.Tickets
    )
    NavigationRail(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxHeight()
    ) {
        val navBackStackEntry by controller.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            tabTargets.forEach { screen ->
                val isSelected =
                    currentDestination?.hierarchy?.any { it.route == screen.route } == true
                NavigationRailItem(
                    selected = isSelected,
                    colors = NavigationRailItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                        unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                        indicatorColor = MaterialTheme.colorScheme.background
                    ),
                    onClick = {
                        controller.navigate(screen.route) {
                            popUpTo(controller.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
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
                    label = {
                        Text(
                            text = stringResource(id = screen.title),
                            style = TextStyle(
                                fontSize = 8.sp,
                                lineHeight = 10.sp,
                                fontWeight = FontWeight(500),
                                textAlign = TextAlign.Center,
                                letterSpacing = 0.8.sp,
                            )
                        )
                    }
                )

            }
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}
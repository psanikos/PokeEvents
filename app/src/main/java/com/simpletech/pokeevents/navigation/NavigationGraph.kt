package com.simpletech.pokeevents.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.simpletech.pokeevents.MainView
import com.simpletech.pokeevents.home.HomeView
import com.simpletech.pokeevents.home.HomeViewModel
import com.simpletech.pokeevents.home.composables.NotImplementedView
import org.koin.androidx.compose.getViewModel

sealed class GraphTargets(val routes: String) {
    object Main: GraphTargets("MainRoutes")
    object Tabs: GraphTargets("TabRouted")
}
fun NavGraphBuilder.tabGraph(navController: NavHostController) {
    navigation(
        startDestination = BottomNavigationTarget.Home.route,
        route = GraphTargets.Tabs.routes
    ) {
        composable(BottomNavigationTarget.Home.route) {
            val homeViewModel = getViewModel<HomeViewModel>()
            HomeView(
                navController,
                viewModel = homeViewModel
            )
        }
        composable(BottomNavigationTarget.Tickets.route) {
            NotImplementedView()
        }
        composable(BottomNavigationTarget.Search.route) {
            NotImplementedView()
        }
    }
}

fun NavGraphBuilder.mainGraph(navController: NavHostController) {
    navigation(
        startDestination = NavigationTarget.Home.route,
        route = GraphTargets.Main.routes
    ) {
        composable(NavigationTarget.Home.route) {
            MainView(navController = navController)
        }
        composable(NavigationTarget.Register.route) {
            NotImplementedView()
        }
    }
}
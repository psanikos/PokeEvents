package com.simpletech.pokeevents.navigation

import androidx.annotation.DrawableRes
import com.simpletech.pokeevents.R

sealed class BottomNavigationTarget(
    val route: String,
    val title: String,
    @DrawableRes val image: Int
) {
object Home: BottomNavigationTarget(
    route = "home",
    title = "HOME",
    image = R.drawable.home
)
    object Search: BottomNavigationTarget(
        route = "search",
        title = "SEARCH",
        image = R.drawable.search
    )
    object Tickets: BottomNavigationTarget(
        route = "tickets",
        title = "TICKETS",
        image = R.drawable.ticket
    )
}

sealed class NavigationTarget(
    val route: String,
) {
    object Home: NavigationTarget("HomePage")
    object Register: NavigationTarget("Register")
    // Add more for in screen navigation
}
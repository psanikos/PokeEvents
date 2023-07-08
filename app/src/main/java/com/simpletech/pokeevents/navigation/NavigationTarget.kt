package com.simpletech.pokeevents.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.simpletech.pokeevents.R

sealed class BottomNavigationTarget(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val image: Int
) {
    object Home : BottomNavigationTarget(
        route = "home",
        title = R.string.home,
        image = R.drawable.home
    )

    object Search : BottomNavigationTarget(
        route = "search",
        title = R.string.search,
        image = R.drawable.search
    )

    object Tickets : BottomNavigationTarget(
        route = "tickets",
        title = R.string.tickets,
        image = R.drawable.ticket
    )
}

sealed class NavigationTarget(
    val route: String,
) {
    object Home : NavigationTarget("HomePage")
    object Register : NavigationTarget("Register")

}
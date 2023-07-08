package com.simpletech.pokeevents.models

import androidx.annotation.DrawableRes
import com.simpletech.pokeevents.R

data class EventModel(
    val header: String?,
    val title: String,
    val date: String,
    val location: String,
    @DrawableRes val image: Int
) {
    companion object {
        @JvmStatic
        val promotedEvent = EventModel(
            header = "Popular in Kanto",
            title = "The Dream Continues!",
            date = "Tue 4 Oct",
            location = "Pallet Town",
            image = R.drawable.thumbnail
        )

        @JvmStatic
        val events = listOf(
            EventModel(
                header = null,
                title = "Legend? Go! Friends? Go!",
                date = "Sun 18 Oct",
                location = "Cinnabar Island",
                image = R.drawable.listthumbnail
            ),
            EventModel(
                header = null,
                title = "EXHALE with Professor Oak",
                date = "Sun 18 Oct",
                location = "Celadon City",
                image = R.drawable.listthumbnail2
            ),
            EventModel(
                header = null,
                title = "Explore the seas",
                date = "Mon 19 Oct",
                location = "Cerulean City",
                image = R.drawable.thumbnaillist3
            )
        )
    }
}



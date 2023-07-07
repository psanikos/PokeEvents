package com.simpletech.pokeevents.home.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simpletech.pokeevents.R
import com.simpletech.pokeevents.ui.theme.KBodyRegular
import com.simpletech.pokeevents.ui.theme.KMediumTitle
import com.simpletech.pokeevents.ui.theme.PokeEventsTheme

@Composable
fun WeeklyEvents() {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "This week",
            style = MaterialTheme.typography.KMediumTitle,
            textAlign = TextAlign.Center,
            modifier = Modifier.height(24.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .height(IntrinsicSize.Max)
        ) {
            EventCard(
                title = "Legend? Go! Friends? Go!",
                subtitle1 = "Sun 18 Oct",
                subtitle2 = "Cinnabar Island",
                image = R.drawable.listthumbnail
            )
            EventCard(
                title = "EXHALE with Professor Oak",
                subtitle1 = "Sun 18 Oct",
                subtitle2 = "Celadon City",
                image = R.drawable.listthumbnail2
            )
            EventCard(
                title = "Explore the seas",
                subtitle1 = "Mon 19 Oct",
                subtitle2 = "Cerulean City",
                image = R.drawable.thumbnaillist3
            )
        }
    }
}

@Composable
fun EventCard(
    title: String,
    subtitle1: String,
    subtitle2: String,
    @DrawableRes image: Int
) {
    Column(
        verticalArrangement = Arrangement
            .spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxHeight()
            .width(168.dp)
            .background(
                color = Color(0xFF161616),
                shape = RoundedCornerShape(
                    topStart = 4.dp,
                    topEnd = 4.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            )
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "image description",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(size = 4.dp))
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(size = 4.dp)
                )
                .width(168.dp)
                .height(168.dp)
        )
        Column(
            verticalArrangement = Arrangement
                .spacedBy(0.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.KBodyRegular,
                maxLines = 2,
                textAlign = TextAlign.Start
            )
            Text(
                text = subtitle1,
                style = MaterialTheme.typography.KBodyRegular,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Text(
                text = subtitle2,
                style = MaterialTheme.typography.KBodyRegular,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Preview
@Composable
fun WeeklyEventsPreview() {
    PokeEventsTheme {
        WeeklyEvents()
    }
}
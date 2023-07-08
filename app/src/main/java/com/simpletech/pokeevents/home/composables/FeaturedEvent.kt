package com.simpletech.pokeevents.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.simpletech.pokeevents.ui.theme.KLargeTitle
import com.simpletech.pokeevents.ui.theme.KMediumTitle
import com.simpletech.pokeevents.ui.theme.PokeEventsTheme

@Composable
fun FeaturedEvent() {
    Column(
        verticalArrangement = Arrangement
            .spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = Color(0xFF161616),
                shape = RoundedCornerShape(
                    topStart = 4.dp,
                    topEnd = 4.dp,
                    bottomEnd =
                    0.dp, bottomStart = 0.dp
                )
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.thumbnail),
            contentDescription = "image description",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(size = 4.dp))
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(size = 4.dp)
                )
                .height(343.dp)
                .fillMaxWidth()
        )
        Column(
            verticalArrangement = Arrangement
                .spacedBy(0.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Popular in Kanto",
                style = MaterialTheme.typography.KMediumTitle,
                textAlign = TextAlign.Center,
                modifier = Modifier.height(24.dp),
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "The Dream Continues!",
                style = MaterialTheme.typography.KLargeTitle,
                textAlign = TextAlign.Center,
                modifier = Modifier.height(30.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Tue 4 Oct",
                    style = MaterialTheme.typography.KBodyRegular,
                    color = MaterialTheme.colorScheme.onSecondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.height(16.dp)
                )
                Text(
                    text = "Pallet Town",
                    style = MaterialTheme.typography.KBodyRegular,
                    color = MaterialTheme.colorScheme.onSecondary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.height(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun FeatureEventPreview() {
    PokeEventsTheme {
        FeaturedEvent()
    }
}
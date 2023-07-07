package com.simpletech.pokeevents.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simpletech.pokeevents.R
import com.simpletech.pokeevents.ui.theme.PokeEventsTheme

@Composable
fun FeaturedEvent() {
    Column(
        verticalArrangement = Arrangement
            .spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .height(437.dp)
            .background(
                color = Color(0xFF161616),
                shape = RoundedCornerShape(
                    topStart = 4.dp,
                    topEnd = 4.dp,
                    bottomEnd =
                    0.dp, bottomStart = 0.dp
                )
            )
            .padding(top = 24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.thumbnail),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .clip(RoundedCornerShape(size = 4.dp))
                .border(
                    width = 1.dp,
                    color = Color(0xFF323232),
                    shape = RoundedCornerShape(size = 4.dp)
                )
                .height(343.dp)
                .fillMaxWidth()
        )
        Column(
            verticalArrangement = Arrangement
                .spacedBy(0.dp),
            horizontalAlignment = Alignment.Start) {
            Text(
                text = "Popular in Kanto",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFDDFF55),
                    textAlign = TextAlign.Center
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.height(24.dp)
            )
            Text(
                text = "The Dream Continues!",
                style = TextStyle(
                    fontSize = 22.sp,
                    lineHeight = 30.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.height(30.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Tue 4 Oct",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFC2C2C2),
                        textAlign = TextAlign.Center
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.height(16.dp)
                )
                Text(
                    text = "Pallet Town",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFC2C2C2),
                        textAlign = TextAlign.Center
                    ),
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
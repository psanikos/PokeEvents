package com.simpletech.pokeevents.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.simpletech.pokeevents.R
import com.simpletech.pokeevents.navigation.NavigationTarget
import com.simpletech.pokeevents.ui.theme.KBodyLarge
import com.simpletech.pokeevents.ui.theme.KButtonLarge
import com.simpletech.pokeevents.ui.theme.PokeEventsTheme

@Composable
fun PokeTopBar(
    controller: NavHostController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                top = 8.dp,
                bottom = 24.dp
            )
            .height(40.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pin),
                contentDescription = "image description",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(32.dp)
            )

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(0.dp),
                modifier = Modifier
                    .width(IntrinsicSize.Max)
            ) {
                Text(
                    text = "Kanto",
                    style = MaterialTheme.typography.KBodyLarge,
                    color = Color.White,
                    modifier = Modifier.height(30.dp),
                    textAlign = TextAlign.Center
                )
                Box(
                    modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            onClick = {
                controller.navigate(NavigationTarget.Register.route)
            },
            modifier = Modifier
                .width(170.dp)
                .height(40.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(size = 4.dp)
                )
                .padding(
                    start = 16.dp,
                    top = 8.dp,
                    end = 16.dp,
                    bottom = 8.dp
                ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.sign_register),
                    style = MaterialTheme.typography.KButtonLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Preview
@Composable
fun PokeTopBarPreview() {
    PokeEventsTheme {
        PokeTopBar(controller = rememberNavController())
    }
}
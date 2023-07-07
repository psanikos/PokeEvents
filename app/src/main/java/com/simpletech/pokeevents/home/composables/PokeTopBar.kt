package com.simpletech.pokeevents.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.simpletech.pokeevents.R
import com.simpletech.pokeevents.navigation.NavigationTarget
import com.simpletech.pokeevents.ui.theme.PokeEventsTheme

@Composable
fun PokeTopBar(
    controller: NavHostController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
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
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Kanto",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 30.sp,
                        fontWeight = FontWeight(500),
                    ),
                    color = Color.White
                )
                Box(
                    modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth()
                        .padding(end = 8.dp)
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
                .weight(2f)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(size = 4.dp)
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(
                text = "Sign In or Register",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    //letterSpacing = 0.32.sp,
                ),
                color = MaterialTheme.colorScheme.onPrimary
            )
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
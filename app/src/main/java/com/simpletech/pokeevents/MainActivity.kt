package com.simpletech.pokeevents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.simpletech.pokeevents.ui.theme.PokeEventsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeEventsTheme {
               MyApp()
            }
        }
    }
}

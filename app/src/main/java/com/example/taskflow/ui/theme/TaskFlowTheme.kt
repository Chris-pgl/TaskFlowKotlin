package com.example.taskflow.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/**
 * TaskFlowTheme è il tema Material3 dell'applicazione
 * Tutti i componenti di Material3 leggono AUTOMATICAMENTE questi colori
 */
@Composable
fun TaskFlowTheme(content: @Composable () -> Unit){
    MaterialTheme(
        colorScheme = lightColorScheme(
            /**
             * primary: colore principale (bottoni, TopAppBar)
             */
            primary = Color (0xFF263238L), //grigio scuro
            secondary = Color (0xFF2E7D32L) //verde molto opaco
        )
    )
    {
        content()
    }
}
package com.example.sharedpreferences

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.sharedpreferences.ui.screen.SettingsScreen
import com.example.sharedpreferences.ui.theme.SharedPreferencesTheme

class MainActivity : ComponentActivity() {

    /**
     * Funció que s'executa al capturar l'event d'obrir la app
     * És l'entry point de la app.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SharedPreferencesTheme {
                Surface {
                    SettingsScreen()
                }
            }
        }
    }
}

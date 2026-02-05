package com.example.sharedpreferences.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sharedpreferences.data.SettingsRepository
import com.example.sharedpreferences.ui.viewmodels.SettingsViewModel
import com.example.sharedpreferences.ui.viewmodels.SettingsViewModelFactory

@Composable
fun SettingsScreen() {
    val context = LocalContext.current

    // 1. Instanciem el Repository
    val repository = remember { SettingsRepository(context) }

    // 2. Instanciem el ViewModel fent servir la Factory
    val viewModel: SettingsViewModel = viewModel(
        factory = SettingsViewModelFactory(repository)
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hola, ${viewModel.nomUsuari}!",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = viewModel.nomUsuari,
            onValueChange = { viewModel.actualitzarNom(it) },
            label = { Text("Escriu el teu nom:") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "La dada es guarda automàticament al XML mentre escrius.",
            style = MaterialTheme.typography.bodySmall
        )
    }
}
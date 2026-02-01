package com.example.sharedpreferences.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sharedpreferences.data.SettingsRepository

// --- LA LÒGICA ---
class SettingsViewModel(private val repository: SettingsRepository) : ViewModel() {
    var nomUsuari by mutableStateOf(repository.obtenirNom())
        private set

    fun actualitzarNom(nouNom: String) {
        nomUsuari = nouNom
        repository.guardarNom(nouNom)
    }
}

// Aquesta classe és el que guarda la peça que necessitem (el repository)
class SettingsViewModelFactory(private val repository: SettingsRepository) : ViewModelProvider.Factory {

    // Aquesta funció la crida Android per crear el ViewModel
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        // 1. Comprovem que ens demanen el ViewModel correcte
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {

            // 2. Creem el ViewModel manualment i li "injectem" el repository
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel(repository) as T
        }

        // Si ens demanen un altre tipus de viewmodel, donem error
        throw IllegalArgumentException("Classe ViewModel desconeguda")
    }
}
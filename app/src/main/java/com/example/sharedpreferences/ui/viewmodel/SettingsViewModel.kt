package com.example.sharedpreferences.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.sharedpreferences.model.SettingsRepository

// --- LA LÒGICA ---
class SettingsViewModel(repository: SettingsRepository) : ViewModel() {
    private val repository: SettingsRepository = repository
    var nomUsuari by mutableStateOf(repository.obtenirNom())
        private set


    /**
     * Setter de l'atribut nomUsuari
     * @author RIS
     */
    fun actualitzarNomUsuari(nouNom: String) {
        this.nomUsuari = nouNom
        this.repository.guardarNom(this.nomUsuari)
    }
}
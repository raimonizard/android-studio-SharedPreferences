package com.example.sharedpreferences.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sharedpreferences.model.SettingsRepository

// Aquesta classe és el que guarda la peça que necessitem (el repository)
class SettingsViewModelFactory: ViewModelProvider.Factory {
    private val repository: SettingsRepository

    /**
     * Constructor específic que rep un objecte SettingsRepository per a poder init
     * @author RIS
     */
    constructor(repository: SettingsRepository){
        this.repository = repository
    }

    /**
     * Aquesta funció la crida Android per crear el ViewModel
     */
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
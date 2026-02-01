package com.example.sharedpreferences.data

import android.content.Context
import android.content.SharedPreferences

class SettingsRepository(context: Context) {
    // Creem o obrim el fitxer XML anomenat "AppSettings"
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("AppSettings", Context.MODE_PRIVATE)

    // Funció per guardar el nom
    fun guardarNom(nom: String) {
        sharedPreferences.edit().putString("nom_usuari", nom).apply()
    }

    // Funció per llegir el nom (retorna buit si no existeix)
    fun obtenirNom(): String {
        return sharedPreferences.getString("nom_usuari", "") ?: ""
    }
}
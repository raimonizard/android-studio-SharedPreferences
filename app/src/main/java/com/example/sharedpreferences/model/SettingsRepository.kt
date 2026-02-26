package com.example.sharedpreferences.model

import android.content.Context
import android.content.SharedPreferences

class SettingsRepository {
    private val context: Context
    private val sharedPreferences: SharedPreferences

    /**
     * Constructor específic amb nomFitxer i context
     * @author RIS
     */
    constructor(nomFitxer: String, context: Context){
        this.context = context
        this.sharedPreferences = context.getSharedPreferences(nomFitxer, Context.MODE_PRIVATE)
    }

    /**
     * Mètode per guardar settings al document de preferències XML
     */
    fun <T> saveSettingValue(key: String, value: T) {
        with(sharedPreferences.edit()) {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
                else -> throw IllegalArgumentException("Unsupported type")
            }
            apply()
        }
    }

    /**
     * Mètode per a llegir les dades del fitxer de preferències XML.
     * @author RIS
     */
    fun <T> getSettingValue(key: String, defaultValue: T): T {
        return when (defaultValue) {
            is String -> sharedPreferences.getString(key, defaultValue) as T
            is Int -> sharedPreferences.getInt(key, defaultValue) as T
            is Boolean -> sharedPreferences.getBoolean(key, defaultValue) as T
            is Float -> sharedPreferences.getFloat(key, defaultValue) as T
            is Long -> sharedPreferences.getLong(key, defaultValue) as T
            else -> throw IllegalArgumentException("Unsupported type")
        }
    }


    /**
     * Mètode per guardar les dades de l'atribut 'nom_usuari' al arxiu de preferències compartides.
     * @author RIS
     */
    fun guardarNom(valor_nom: String) {
        var key: String = "nom_usuari"
        sharedPreferences.edit().putString(key, valor_nom).apply()
    }

    /**
     * Funció per llegir el nom del document de preferències compartides (retorna buit si no existeix)
     * @author RIS
     */
    fun obtenirNom(): String {
        var key: String = "nom_usuari"
        var  value: String? = ""

        value = sharedPreferences.getString(key, "")

        if (value.isNullOrBlank())
            value = "Anònim"

        return value
    }
}
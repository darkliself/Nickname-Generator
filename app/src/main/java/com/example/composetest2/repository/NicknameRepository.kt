package com.example.composetest2.repository

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first

class NicknameRepository(val context: Context) {

//    private val Context.dataStore by preferencesDataStore(name = "nickname")

    companion object SingletonRepo {
        private val Context.dataStore by preferencesDataStore(name = "nickname")

    }

    suspend fun save(key:String, value: String) {
        context.dataStore.edit {
            it[stringPreferencesKey(key)] = value
        }
    }

    suspend fun delete(key: String) {
        context.dataStore.edit {
            it.remove(stringPreferencesKey(key))
        }
    }

    suspend fun readAll(): Map<Preferences.Key<*>, Any> {
        return context.dataStore.data.first().asMap()
    }

    suspend fun count(): Int {
        return context.dataStore.data.first().asMap().count()
    }
}
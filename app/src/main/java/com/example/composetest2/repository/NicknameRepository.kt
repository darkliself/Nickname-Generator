package com.example.composetest2.repository

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import javax.inject.Inject


private val Context.dataStore by preferencesDataStore(name = "nickname")

class NicknameRepository @Inject constructor(
    @ApplicationContext private val context: Context) {

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

    suspend fun deleteAll() {
        context.dataStore.edit {
            it.clear()
        }
    }

    suspend fun getAll(): Map<String, String> {
        val result = mutableMapOf<String, String>()
        context.dataStore.data.first().asMap().forEach { (key, value) ->
            result[key.name] = value.toString()
        }
        return result
    }

    suspend fun count(): Int {
        return context.dataStore.data.first().asMap().count()
    }
}
package com.example.composetest2.repository

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

class NicknameRepository(context: Context) {
    private val innerContext = context
    private val Context.dataStore by preferencesDataStore(name = "nickname")


}
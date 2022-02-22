package com.example.composetest2.viewmodel

import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetest2.repository.NicknameRepository
import kotlinx.coroutines.launch

class NicknameViewModel(
    private val repository: NicknameRepository
) : ViewModel() {
    init {
        viewModelScope.launch {

        }
    }

    suspend fun saveNickname(key: String, value: String) {
        repository.save(key, value)
    }

    suspend fun readAll(): Map<Preferences.Key<*>, Any> {
        return repository.readAll()
    }
}
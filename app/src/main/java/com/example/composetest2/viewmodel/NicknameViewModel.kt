package com.example.composetest2.viewmodel

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetest2.repository.NicknameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NicknameViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val repository = NicknameRepository(context)

    var state: Map<Preferences.Key<*>, Any> = emptyMap<Preferences.Key<*>, Any>()

    init {
        viewModelScope.launch {
//            val result  = repository.readAll()
//            state = result
        }
    }

    suspend fun saveNickname(value: String) {
        if (!repository.getAll().values.any { it == value }) {
            repository.save(value.hashCode().toString(), value)
        }
    }

    suspend fun delete(key: String) {
        repository.delete(key)
    }

    suspend fun readAll(): Map<String, String> {
        return repository.getAll()
    }

    suspend fun clearRepo() {
        repository.deleteAll()
    }

    suspend fun isNotEmpty(): Boolean {
        return repository.count() > 0
    }
}
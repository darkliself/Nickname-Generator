package com.example.nickname_generator.viewmodel

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import com.example.nickname_generator.model.nickname.NicknameData
import com.example.nickname_generator.repository.NicknameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class NicknameViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val repository = NicknameRepository(context)
    var state: Map<Preferences.Key<*>, Any> = emptyMap()

    // proto store
    suspend fun saveToProto(nickname: NicknameData) {
        if (!repository.containsInStore(nickname.hashCode().toString())) {
            repository.saveToProto(nickname.hashCode().toString(), nickname)
        }
    }

    suspend fun readFromProto(): Map<String, NicknameData> {
        return repository.readFromProto()
    }

    suspend fun removeFromProto(key: String) {
        repository.removeFromProto(key)
    }
}
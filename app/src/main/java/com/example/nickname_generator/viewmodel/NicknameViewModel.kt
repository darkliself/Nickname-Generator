package com.example.nickname_generator.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nickname_generator.model.nickname.NicknameData
import com.example.nickname_generator.repository.NicknameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NicknameViewModel @Inject constructor(
    private val repository: NicknameRepository
) : ViewModel() {

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
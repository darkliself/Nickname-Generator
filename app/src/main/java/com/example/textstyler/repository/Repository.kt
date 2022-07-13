package com.example.textstyler.repository

import android.content.Context
import androidx.datastore.dataStore
import androidx.datastore.preferences.preferencesDataStore
import com.example.textstyler.model.nickname.NicknameData
import com.example.textstyler.model.nickname.NicknameSerializer
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject


//private val Context.dataStore by preferencesDataStore(name = "nickname")
private val Context.protoDataStore by dataStore( "app_data.json", NicknameSerializer)

class NicknameRepository @Inject constructor(
    @ApplicationContext private val context: Context) {

    suspend fun containsInStore(key: String): Boolean {
        return context.protoDataStore.data.first().list.containsKey(key)
    }

    suspend fun saveToProto(key: String, nickname: NicknameData) {
        if (!containsInStore(nickname.hashCode().toString())) {
            val tmpCopy = readFromProto().toMutableMap()
            tmpCopy[key] = nickname
            context.protoDataStore.updateData {
                it.copy(list = tmpCopy)
            }
        }
    }

    suspend fun readFromProto(): Map<String, NicknameData> {
        return context.protoDataStore.data.first().copy().list
    }

    suspend fun clearProtoStore() {
        context.protoDataStore.updateData {
            it.copy(list = emptyMap())
        }
    }

    suspend fun removeFromProto(key: String) {
        context.protoDataStore.updateData {
            val tmp = readFromProto().toMutableMap()
            tmp.remove(key)
            it.copy(list = tmp)
        }
    }
}
package com.example.textstyler.model.nickname

import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object NicknameSerializer : Serializer<NicknameList> {
    override val defaultValue: NicknameList
            get() = NicknameList(mapOf())
    override suspend fun readFrom(input: InputStream): NicknameList {
        return try {
            Json.decodeFromString(
                deserializer = NicknameList.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun writeTo(t: NicknameList, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = NicknameList.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }
}
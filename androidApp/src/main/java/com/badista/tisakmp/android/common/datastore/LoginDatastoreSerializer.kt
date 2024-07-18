package com.badista.tisakmp.android.common.datastore

import androidx.datastore.core.Serializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object LoginDatastoreSerializer: Serializer<LoginDatastore> {

    override val defaultValue: LoginDatastore
        get() = LoginDatastore()

    override suspend fun readFrom(input: InputStream): LoginDatastore {
        return try {
            Json.decodeFromString(
                deserializer = LoginDatastore.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (serializationException: SerializationException){
            defaultValue
        }
    }

    override suspend fun writeTo(t: LoginDatastore, output: OutputStream) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = LoginDatastore.serializer(),
                    value = t
                ).encodeToByteArray()
            )
        }
    }

}
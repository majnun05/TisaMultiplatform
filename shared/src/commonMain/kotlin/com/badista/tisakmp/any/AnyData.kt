package com.badista.tisakmp.any

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

@Serializable
sealed class AnyData {
    @Serializable
    @SerialName("general")
    data class StringData(val general: String): AnyData()

    @Serializable
    @SerialName("int")
    data class NumberData(val value: Int): AnyData()
}

val json = Json {
    serializersModule = SerializersModule {
        polymorphic(AnyData::class) {
            subclass(AnyData.StringData::class)
            subclass(AnyData.NumberData::class)
        }
    }
}

val anyObject: AnyData = AnyData.StringData("Hello")
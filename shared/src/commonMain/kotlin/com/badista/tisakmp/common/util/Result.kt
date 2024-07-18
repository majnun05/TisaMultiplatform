package com.badista.tisakmp.common.util

import kotlinx.serialization.Contextual

sealed class Result<T>(
    val data: T? = null,
    val message: Any? = null
){
    class Error<T>(data: T? = null, message: Any? = null): Result<T>(data, message)
    class Success<T>(data: T): Result<T>(data)
}
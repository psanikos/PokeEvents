package com.simpletech.domain.utils

import java.lang.Exception

sealed class NetworkResponseResult<out R> {
    data class Success<out T>(val data: T): NetworkResponseResult<T>()
    data class Failure(val error: Exception): NetworkResponseResult<Nothing>()

}
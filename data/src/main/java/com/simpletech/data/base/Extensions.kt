package com.simpletech.data.base

fun String?.thisOrEmpty(): String = this ?: ""
fun Double?.thisOrEmpty(): Double = this ?: 0.0
fun Long?.thisOrEmpty(): Long = this ?: 0L
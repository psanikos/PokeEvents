package com.simpletech.data.di

import android.util.Log
import com.simpletech.data.services.PokeRepositoryImpl
import com.simpletech.data.storage.RealmService
import com.simpletech.domain.repositories.PokeRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val dataInjections = module {
    single<HttpClient> {
        HttpClient(Android) {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d("KTOR REQUEST", message)
                    }
                }
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    single<RealmService> { RealmService() }

    single<PokeRepository> { PokeRepositoryImpl(get(), get())  }
}
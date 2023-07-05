package com.simpletech.data.services

import com.simpletech.domain.repositories.PokeRepository
import io.ktor.client.HttpClient

class PokeRepositoryImpl(
    private val client: HttpClient
): PokeRepository {
    override suspend fun getFeaturedEvent() {
        TODO("Not yet implemented")
    }

    override suspend fun getWeekEvents() {
        TODO("Not yet implemented")
    }

    override suspend fun getPopular() {
        TODO("Not yet implemented")
    }
}
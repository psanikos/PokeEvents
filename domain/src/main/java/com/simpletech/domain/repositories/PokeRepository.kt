package com.simpletech.domain.repositories

interface PokeRepository {
    suspend fun getFeaturedEvent()
    suspend fun getWeekEvents()
    suspend fun getPopular()
}
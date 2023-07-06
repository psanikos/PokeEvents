package com.simpletech.domain.use_cases

import com.simpletech.domain.repositories.PokeRepository
import com.simpletech.domain.use_cases.use_case_services.FetchWeekEventsUseCase

class FetchWeekEventsUseCaseImpl(
    private val repo: PokeRepository
): FetchWeekEventsUseCase {
    override suspend fun execute() {
        TODO("Not yet implemented since pokeApi does not provide this data")
    }
}
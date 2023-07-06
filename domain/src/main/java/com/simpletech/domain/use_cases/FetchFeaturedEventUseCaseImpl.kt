package com.simpletech.domain.use_cases

import com.simpletech.domain.repositories.PokeRepository
import com.simpletech.domain.use_cases.use_case_services.FetchFeaturedEventUseCase

class FetchFeaturedEventUseCaseImpl(
    private val repo: PokeRepository
): FetchFeaturedEventUseCase {
    override suspend fun execute() {
        TODO("Not yet implemented since pokeApi does not provide this data")
    }
}
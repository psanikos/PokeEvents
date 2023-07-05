package com.simpletech.domain.di

import com.simpletech.domain.use_cases.FetchFeaturedEventUseCaseImpl
import com.simpletech.domain.use_cases.FetchPopularPokemonUseCaseImpl
import com.simpletech.domain.use_cases.FetchWeekEventsUseCaseImpl
import com.simpletech.domain.use_cases.use_case_services.FetchFeaturedEventUseCase
import com.simpletech.domain.use_cases.use_case_services.FetchPopularPokemonUseCase
import com.simpletech.domain.use_cases.use_case_services.FetchWeekEventsUseCase
import org.koin.dsl.module

val domainInjections = module {
    single<FetchFeaturedEventUseCase> {  FetchFeaturedEventUseCaseImpl(get()) }
    single<FetchWeekEventsUseCase> { FetchWeekEventsUseCaseImpl(get()) }
    single<FetchPopularPokemonUseCase> { FetchPopularPokemonUseCaseImpl(get()) }
}
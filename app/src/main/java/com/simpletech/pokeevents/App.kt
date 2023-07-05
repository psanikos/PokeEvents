package com.simpletech.pokeevents

import android.app.Application
import com.simpletech.data.di.dataInjections
import com.simpletech.domain.di.domainInjections
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        GlobalContext.startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataInjections,
                    domainInjections
                )
            )
        }
    }
}
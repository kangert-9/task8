package com.example.task3

import android.app.Application
import com.example.task3.navigation.CustomRouter
import com.github.terrakok.cicerone.Cicerone
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }


    companion object Navigation {

        private val cicerone: Cicerone<CustomRouter> by lazy {
            Cicerone.create(CustomRouter())
        }
        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router
    }
}
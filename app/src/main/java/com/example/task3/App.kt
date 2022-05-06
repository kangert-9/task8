package com.example.task3

import android.app.Application
import androidx.room.Room
import com.example.task3.data.bd.HistoryDao
import com.example.task3.data.bd.HistoryDataBase
import com.example.task3.navigation.CustomRouter
import com.github.terrakok.cicerone.Cicerone
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }

    companion object {
        private var appInstance: App? = null
        private var db: HistoryDataBase? = null
        private const val DB_NAME = "History.db"
        fun getHistoryDao(): HistoryDao {
            if (db == null) {
                synchronized(HistoryDataBase::class.java) {
                    if (db == null) {
                        if (appInstance == null) throw
                        IllegalStateException("Application is null while creating DataBase")
                        db = Room.databaseBuilder(
                            appInstance!!.applicationContext,
                            HistoryDataBase::class.java,
                            DB_NAME)
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return db!!.historyDao()
        }

        private val cicerone: Cicerone<CustomRouter> by lazy {
            Cicerone.create(CustomRouter())
        }
        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router
    }
}
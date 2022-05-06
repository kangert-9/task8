package com.example.task3

import com.example.task3.data.DataModel
import com.example.task3.data.TranslateRepository
import com.example.task3.data.TranslateRepositoryImpl
import com.example.task3.mvpuser.AppState
import com.example.task3.mvpuser.BaseViewModel
import com.example.task3.mvpuser.TranslateViewModel
import org.koin.dsl.module

val application = module {
    single<TranslateRepository<List<DataModel>>> {
        TranslateRepositoryImpl()
    }
}
    val mainScreen = module {
        factory< BaseViewModel <AppState>> { TranslateViewModel() }
    }
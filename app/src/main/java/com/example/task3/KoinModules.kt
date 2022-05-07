package com.example.task3

import com.example.task3.data.DataModel
import com.example.task3.data.TranslateRepository
import com.example.task3.data.TranslateRepositoryImpl
import com.example.task3.mvpuser.TranslateFragment
import com.example.task3.mvpuser.TranslateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<TranslateRepository<List<DataModel>>> {
        TranslateRepositoryImpl()
    }
}

val mainScreen = module {
    scope(named<TranslateFragment>()) {
        viewModel { TranslateViewModel() }
    }
}
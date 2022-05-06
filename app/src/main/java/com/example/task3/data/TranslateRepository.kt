package com.example.task3.data

import com.example.task3.mvpuser.AppState

interface TranslateRepository<T> {
    suspend fun fetchTranslateByWord(word: String): List<DataModel>
    suspend fun saveToDB(appState: AppState)
}
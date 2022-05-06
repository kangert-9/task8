package com.example.task3.data

interface TranslateRepository<T> {
    suspend fun fetchTranslateByWord(word: String): List<DataModel>
}
package com.example.task3.data

import com.example.task3.data.retrofit.WordsApiFactory

class TranslateRepositoryImpl : TranslateRepository<List<DataModel>> {

    private val gitHubApi = WordsApiFactory.create()

    override suspend fun fetchTranslateByWord(word: String): List<DataModel> {
        return gitHubApi.searchAsync(word).await()
    }
}
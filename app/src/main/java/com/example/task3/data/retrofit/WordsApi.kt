package com.example.task3.data.retrofit

import com.example.task3.data.DataModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface WordsApi {

    @GET("words/search")
    fun searchAsync (@Query("search") wordToSearch: String): Deferred<List<DataModel>>

}
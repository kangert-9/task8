package com.example.task3.data.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object WordsApiFactory {

    private val gson: Gson =
        GsonBuilder()
            .create()

    private val gitHubApi: WordsApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://dictionary.skyeng.ru/api/public/v1")
            .client(
                OkHttpClient.Builder()
                    .addNetworkInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .build()
            )
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(WordsApi::class.java)
    }


    fun create(): WordsApi = gitHubApi
}
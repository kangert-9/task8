package com.example.task3.mvpuser

import com.example.task3.data.DataModel

sealed class AppState {
    data class Success(val data: List<DataModel>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
package com.example.task3.mvpuser

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TranslateViewModel: BaseViewModel<AppState>() {

    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData
    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }
    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.value = AppState.Loading
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) =
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(AppState.Error(Exception("нет интернета")))
        }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
    }
    override fun onCleared() {
        _mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }
}
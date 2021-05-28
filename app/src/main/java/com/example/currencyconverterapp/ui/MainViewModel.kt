package com.example.currencyconverterapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverterapp.data.model.LatestResponse
import com.example.currencyconverterapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val job = SupervisorJob()
    val repositoriesLiveData = MutableLiveData<LatestResponse>()
    private val ioScope = CoroutineScope(Dispatchers.IO + job)
    init {
        fetchProducts()
    }


    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val data = ioScope.async {
                    return@async repository.getLatestRates()
                }.await()
                repositoriesLiveData.value = data
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        this.job.cancel()
    }
}
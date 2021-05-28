package com.example.currencyconverterapp.data.repository

import com.example.currencyconverterapp.data.model.LatestResponse
import com.example.currencyconverterapp.requests.ApiInterface
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val apiInterface: ApiInterface
) {

    suspend fun getLatestRates(): LatestResponse {
        return apiInterface.getLatestRates()
    }
}
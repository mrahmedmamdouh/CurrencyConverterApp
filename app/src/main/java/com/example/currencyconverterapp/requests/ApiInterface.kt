package com.example.currencyconverterapp.requests

import com.example.currencyconverterapp.BuildConfig.ACCESS_KEY
import com.example.currencyconverterapp.data.model.LatestResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/latest")
    suspend fun getLatestRates(@Query("access_key") accessKey : String = ACCESS_KEY) : LatestResponse


}
package com.example.currencyconverterapp.data.model

data class LatestResponse (

    val success : Boolean,
    val timestamp: Long,
    val base: String,
    val date: String,
    val rates: Map<String,Double>
)
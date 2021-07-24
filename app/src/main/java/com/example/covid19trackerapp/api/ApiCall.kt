package com.example.covid19trackerapp.api

import com.example.covid19trackerapp.data.covidCaseResponce
import retrofit2.http.GET

interface ApiCall {

    @GET("v2/all")
    suspend fun getapidata(): covidCaseResponce

}



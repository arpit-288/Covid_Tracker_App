package com.example.covid19trackerapp.model

import com.example.covid19trackerapp.api.RetrofitInstance
import com.example.covid19trackerapp.data.covidCaseResponce

class Repository {
    suspend fun getapidata(): covidCaseResponce {
        return RetrofitInstance.api.getapidata()
    }


}
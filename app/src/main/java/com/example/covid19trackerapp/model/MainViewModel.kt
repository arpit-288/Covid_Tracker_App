package com.example.covid19trackerapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.example.covid19trackerapp.data.covidCaseResponce
import kotlinx.coroutines.launch


class MainViewModel(private val repository: Repository):ViewModel() {

    val  myResponce:MutableLiveData<covidCaseResponce> = MutableLiveData()

    fun getapidata() {

        viewModelScope.launch {

            val  responce = repository.getapidata()
            myResponce.value  = responce
        }

    }



}
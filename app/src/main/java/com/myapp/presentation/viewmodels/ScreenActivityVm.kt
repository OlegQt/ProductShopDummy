package com.myapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScreenActivityVm:ViewModel() {
    val productList = MutableLiveData<List<String>>()

    init {
        productList.value = listOf("A","W")
    }


}
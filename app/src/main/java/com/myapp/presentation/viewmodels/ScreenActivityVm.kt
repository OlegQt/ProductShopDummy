package com.myapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myapp.domain.models.DummyProductList
import com.myapp.util.Creator

class ScreenActivityVm:ViewModel() {
    val productList = MutableLiveData<List<String>>()

    fun showLst(lst:DummyProductList){
        val i = lst.products.size
    }

    init {
        productList.value = listOf("A","W")
        val loadProductsUseCase = Creator().provideLoadProductsUseCase()
        loadProductsUseCase.execute(""){
            showLst(it)
        }
    }

}
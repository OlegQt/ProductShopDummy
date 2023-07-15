package com.myapp.presentation.viewmodels

import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myapp.domain.models.DummyProduct
import com.myapp.util.Creator

class ScreenActivityVm : ViewModel() {
    val productList = MutableLiveData<List<String>>()
    private val handler = android.os.Handler(Looper.getMainLooper())

    private fun showLst(lst: List<DummyProduct>) {
        val list = lst.map {
            it.title
        }
        productList.value = list
    }

    init {
        val loadProductsUseCase = Creator().provideLoadProductsUseCase()

        //
        loadProductsUseCase.execute("") {
            handler.post() { showLst(it) }
        }
    }

}
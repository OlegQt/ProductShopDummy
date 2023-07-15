package com.myapp.domain.usecase

import android.util.Log
import com.myapp.domain.models.DummyProduct
import com.myapp.domain.repository.DummyProductRepository

class LoadAllDummyProductsUseCase(private val productsRepo:DummyProductRepository) {
    fun execute(searchParam:String,consumer:Consumer){
        val searchThread = Thread({
            try {
                val found = productsRepo.loadDummyProducts(searchParam)
                consumer.consume(found)
            }
            catch (th:Throwable){
                Log.e("DUMMY",th.message.toString())
            }
        },"searchThread")
        searchThread.start()
    }

    fun interface Consumer{
        fun consume(lst:List<DummyProduct>)
    }
}
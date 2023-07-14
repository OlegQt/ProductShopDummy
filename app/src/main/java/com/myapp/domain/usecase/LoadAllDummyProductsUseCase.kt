package com.myapp.domain.usecase

import com.myapp.domain.models.DummyProductList
import com.myapp.domain.repository.DummyProductRepository

class LoadAllDummyProductsUseCase(private val productsRepo:DummyProductRepository) {
    fun execute(searchParam:String,consumer:Consumer){
        try {
            val found = productsRepo.loadDummyProducts(searchParam)
            consumer.consume(found)
        }
        catch (th:Throwable){

        }
    }

    fun interface Consumer{
        fun consume(lst:DummyProductList)
    }
}
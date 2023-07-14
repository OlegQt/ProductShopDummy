package com.myapp.domain.usecase

import com.myapp.domain.models.DummyProductList
import com.myapp.domain.repository.DummyProductRepository

class LoadAllDummyProductsUseCase(private val productsRepo:DummyProductRepository) {
    fun execute():DummyProductList{
        return productsRepo.loadDummyProducts()
    }
}
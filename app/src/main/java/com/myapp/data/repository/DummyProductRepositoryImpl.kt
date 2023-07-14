package com.myapp.data.repository

import com.myapp.domain.models.DummyProduct
import com.myapp.domain.models.DummyProductList
import com.myapp.domain.repository.DummyProductRepository

class DummyProductRepositoryImpl(private val consumer: Consumer): DummyProductRepository {
    override fun loadDummyProducts(): DummyProductList {
        val product = DummyProduct(1,"TestProduct")
        val lst = DummyProductList(listOf(product))
        consumer.consume(lst)
        return lst
    }

    fun interface Consumer{
        fun consume(productLst:DummyProductList)
    }
}
package com.myapp.data.repository

import com.myapp.data.models.DummyProductResponse
import com.myapp.data.network.NetworkClient
import com.myapp.domain.models.DummyProduct
import com.myapp.domain.repository.DummyProductRepository

class DummyProductRepositoryImpl(private val networkClient: NetworkClient) :
    DummyProductRepository {
    override fun loadDummyProducts(searchParams: String): List<DummyProduct> {
        val loadResult = networkClient.doRequest(searchParams)
        if (loadResult.code == 200) {
            val resp = loadResult as DummyProductResponse
            val lst: List<DummyProduct> = resp.products.map {
                DummyProduct(
                    it.id,
                    it.title,
                    it.description,
                    it.price,
                    it.discountPercentage,
                    it.rating,
                    it.stock,
                    it.brand,
                    it.category,
                    it.thumbnail,
                    it.images
                )
            }
            return lst
        } else {
            return emptyList<DummyProduct>()
        }
    }
}
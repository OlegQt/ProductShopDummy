package com.myapp.data.repository

import com.myapp.data.models.Response
import com.myapp.data.network.NetworkClient
import com.myapp.domain.models.DummyProduct
import com.myapp.domain.models.DummyProductList
import com.myapp.domain.repository.DummyProductRepository

class DummyProductRepositoryImpl(private val networkClient: NetworkClient) :
    DummyProductRepository {
    override fun loadDummyProducts(searchParams: String): DummyProductList {
        val loadResult = networkClient.doRequest(searchParams)
        return loadResult as DummyProductList
    }
}
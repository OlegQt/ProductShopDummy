package com.myapp.util

import com.myapp.data.network.RetrofitNetworkClient
import com.myapp.data.repository.DummyProductRepositoryImpl
import com.myapp.domain.repository.DummyProductRepository
import com.myapp.domain.usecase.LoadAllDummyProductsUseCase

class Creator {
    private fun getDummyProductsRepository():DummyProductRepository{
        return DummyProductRepositoryImpl(RetrofitNetworkClient())
    }

    fun provideLoadProductsUseCase():LoadAllDummyProductsUseCase{
        return LoadAllDummyProductsUseCase(getDummyProductsRepository())
    }
}
package com.myapp.util

import com.myapp.data.repository.DummyProductRepositoryImpl
import com.myapp.domain.repository.DummyProductRepository
import com.myapp.domain.usecase.LoadAllDummyProductsUseCase

class Creator {
    private fun getDummyProductsRepository(externalConsumer: DummyProductRepositoryImpl.Consumer):DummyProductRepository{
        return DummyProductRepositoryImpl(consumer = externalConsumer)
    }

    fun provideLoadProductsUseCase(consumer: DummyProductRepositoryImpl.Consumer):LoadAllDummyProductsUseCase{
        return LoadAllDummyProductsUseCase(getDummyProductsRepository(externalConsumer = consumer))
    }
}
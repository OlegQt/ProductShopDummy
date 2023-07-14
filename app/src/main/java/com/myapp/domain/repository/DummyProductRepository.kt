package com.myapp.domain.repository

import com.myapp.domain.models.DummyProductList

interface DummyProductRepository {
    fun loadDummyProducts():DummyProductList
}
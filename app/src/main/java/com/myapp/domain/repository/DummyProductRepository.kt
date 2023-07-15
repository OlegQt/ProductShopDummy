package com.myapp.domain.repository

import com.myapp.domain.models.DummyProduct

interface DummyProductRepository {
    fun loadDummyProducts(searchParams:String):List<DummyProduct>
}
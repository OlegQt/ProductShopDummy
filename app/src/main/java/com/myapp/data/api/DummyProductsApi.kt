package com.myapp.data.api

import com.myapp.domain.models.DummyProductList
import retrofit2.Call
import retrofit2.http.GET

interface DummyProductsApi {
    @GET("products")
    fun getAllProducts() :Call<DummyProductList>
}
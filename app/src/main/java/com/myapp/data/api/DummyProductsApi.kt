package com.myapp.data.api

import com.myapp.data.models.DummyProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface DummyProductsApi {
    @GET("products")
    fun getAllProducts() :Call<DummyProductResponse>
}

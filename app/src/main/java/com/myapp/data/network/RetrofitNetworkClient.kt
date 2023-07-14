package com.myapp.data.network

import com.myapp.data.api.DummyProductsApi
import com.myapp.data.models.DummyProductResponse
import com.myapp.data.models.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitNetworkClient() : NetworkClient {
    private val baseUrl = "https://dummyjson.com/"
    override fun doRequest(searchParams: String) :Response{
        // Создание объекта Retrofit
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl) // Базовый URL для API
            .addConverterFactory(GsonConverterFactory.create()) // Конвертер
            .build()

        // Создание API-сервиса с помощью Retrofit
        val apiService = retrofit.create(DummyProductsApi::class.java)

        val serverResponse = apiService.getAllProducts().execute()
        val response = DummyProductResponse()
        response.code = serverResponse.code()
        response.responseBody = serverResponse?.body()
        return response
    }
}
package com.myapp.data.network

import android.util.Log
import com.myapp.data.api.DummyProductsApi
import com.myapp.data.models.DummyProductResponse
import com.myapp.data.models.Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNetworkClient() : NetworkClient {
    private val baseUrl = "https://dummyjson.com/"
    override fun doRequest(searchParams: String): Response {
        // Создание объекта Retrofit
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl) // Базовый URL для API
            .addConverterFactory(GsonConverterFactory.create()) // Конвертер
            .build()

        // Создание API-сервиса с помощью Retrofit
        val apiService = retrofit.create(DummyProductsApi::class.java)

        val serverResponse = apiService.getAllProducts().execute()
        val body = serverResponse.body() ?: Response()
        body.code = serverResponse.code()
        return body
    }
}
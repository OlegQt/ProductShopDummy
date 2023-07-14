package com.myapp.data.network

import com.myapp.data.models.Response

interface NetworkClient {
    fun doRequest(searchParams:String):Response
}
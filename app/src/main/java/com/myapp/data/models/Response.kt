package com.myapp.data.models

import com.myapp.domain.models.DummyProductList

open class Response {
    var code:Int = 0
}

class DummyProductResponse():Response(){
    var responseBody:DummyProductList? = null
}
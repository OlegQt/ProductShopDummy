package com.myapp.domain.models

data class DummyProduct(
    val id:Long,
    val title:String
)

data class DummyProductList(
    val products:List<DummyProduct>
)
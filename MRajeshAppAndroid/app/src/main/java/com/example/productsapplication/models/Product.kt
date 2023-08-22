package com.example.productsapplication.models

data class Product(
    val productId: Long,
    val productName: String,
    val productDescription: String,
    val productCategoryId: Long,
    val imageUrl: String,
    val price:Double
)

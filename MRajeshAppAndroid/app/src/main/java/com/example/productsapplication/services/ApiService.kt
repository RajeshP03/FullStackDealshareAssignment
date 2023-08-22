package com.example.productsapplication.services


import android.database.Observable
import com.example.productsapplication.models.Category
import com.example.productsapplication.models.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("/get-products")
    suspend fun getProducts(): Response<ArrayList<Product>>

    @GET("/get-categories")
    suspend fun getCategories(): Response<ArrayList<Category>>

    @GET("products/{id}")
    suspend fun getCategoryProducts(@Path("id") category: String): Response<ArrayList<Product>>
}
package com.example.productsapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.productsapplication.models.Category
import com.example.productsapplication.models.Product
import com.example.productsapplication.services.ApiService

class Repository(private val apiService: ApiService) {
    private val productsLiveData = MutableLiveData<ArrayList<Product>>()
    val products: LiveData<ArrayList<Product>>
        get() = productsLiveData

    private val categoriesLiveData = MutableLiveData<ArrayList<Category>>()
    val categories: LiveData<ArrayList<Category>>
        get() = categoriesLiveData

    suspend fun getProducts() {
        val res = apiService.getProducts()
        if (res.isSuccessful) {
            productsLiveData.postValue(res.body())
        }
    }

    suspend fun getCategories() {
        val res = apiService.getCategories()
        if (res.isSuccessful) {
            categoriesLiveData.postValue(res.body())
        }
    }

    suspend fun getCategoryProducts(category: String) {
        val res = apiService.getCategoryProducts(category)
        if (res.isSuccessful) {
            productsLiveData.postValue(res.body())
        }
    }
}
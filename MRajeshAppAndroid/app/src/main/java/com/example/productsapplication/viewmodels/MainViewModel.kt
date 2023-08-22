package com.example.productsapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productsapplication.models.Category
import com.example.productsapplication.models.Product
import com.example.productsapplication.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    fun getProductsService(category: String){
        if(category.equals("All",true)){
            viewModelScope.launch(Dispatchers.IO) {
                repository.getProducts()
            }
        }else{
            viewModelScope.launch(Dispatchers.IO) {
                repository.getCategoryProducts(category)
            }
        }
    }
    fun getCategoriesService(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCategories()
        }
    }

    val products: LiveData<ArrayList<Product>>
    get() = repository.products

    val categories: LiveData<ArrayList<Category>>
    get() = repository.categories
}
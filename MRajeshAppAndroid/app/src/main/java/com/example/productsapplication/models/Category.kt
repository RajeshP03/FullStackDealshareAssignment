package com.example.productsapplication.models

data class Category(val id: String, val categoryName:String, var isSelected: Boolean = false, val isAllCategory: Boolean = false)
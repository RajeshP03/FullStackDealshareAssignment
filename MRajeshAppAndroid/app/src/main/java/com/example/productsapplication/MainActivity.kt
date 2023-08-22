package com.example.productsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productsapplication.adapters.CategoryAdapter
import com.example.productsapplication.adapters.ProductAdapter
import com.example.productsapplication.databinding.ActivityMainBinding
import com.example.productsapplication.models.Category
import com.example.productsapplication.repository.Repository
import com.example.productsapplication.services.ApiService
import com.example.productsapplication.services.RetrofitHelper
import com.example.productsapplication.viewmodels.MainViewModel
import com.example.productsapplication.viewmodels.MainViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi

class MainActivity : AppCompatActivity(), CategoryAdapter.CategoryCallback {

    private lateinit var binding: ActivityMainBinding
    private val mApiService = RetrofitHelper.getInstance().create(ApiService::class.java)
    private lateinit var mainViewModel: MainViewModel
    private val repository = Repository(mApiService)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initializing the category recycler view
        binding.categoryRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository))[MainViewModel::class.java]

        binding.loaderDullBackground.show()
        binding.dataLoader.show()
        mainViewModel.getCategoriesService()
        mainViewModel.categories.observe(this, Observer {
            val masterCategoryList = ArrayList<Category>()
            masterCategoryList.add(Category("0", "All", isSelected = true, isAllCategory = true))
            for (i in 0 until it.size-1) {
                masterCategoryList.add(it[i])
            }
            //masterCategoryList.dropLast(1)
            binding.categoryRecyclerView.adapter = CategoryAdapter(masterCategoryList, this@MainActivity)
            binding.dataLoader.visibility = View.GONE
        })
        mainViewModel.getProductsService("All")
        mainViewModel.products.observe(this, Observer {
            binding.productRecyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
            binding.productRecyclerView.adapter = ProductAdapter(this@MainActivity, it)
            binding.loaderDullBackground.hide()
            binding.dataLoader.hide()
        })

//            getAndUpdateProducts("All")
//        }
    }


    override fun onCategoryClick(categoryName: String) {
//        getAndUpdateProducts(categoryName)
        binding.loaderDullBackground.show()
        binding.dataLoader.show()
        mainViewModel.getProductsService(categoryName)
    }
}
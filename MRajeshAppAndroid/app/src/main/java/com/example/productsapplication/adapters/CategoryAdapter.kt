package com.example.productsapplication.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.productsapplication.R
import com.example.productsapplication.databinding.CategoryButtonBinding
import com.example.productsapplication.models.Category

class CategoryAdapter(private val categoryList: ArrayList<Category>, private val mCallback: CategoryCallback) :
    RecyclerView.Adapter<CategoryAdapter.CategoryItemViewHolder>() {

    inner class CategoryItemViewHolder(val binding: CategoryButtonBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            binding.categoryButton.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            when (view?.id) {
                (R.id.categoryButton) -> {
                    if (!categoryList[adapterPosition].isSelected) {
                        for (i in 0 until categoryList.size) {
                            if (categoryList[i].isSelected) {
                                categoryList[i].isSelected = false
                            }
                        }
                        categoryList[adapterPosition].isSelected = true
                        mCallback.onCategoryClick(categoryList[adapterPosition].id)
                        notifyDataSetChanged()
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.CategoryItemViewHolder {
        val binding = CategoryButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        holder.binding.categoryName.text = categoryList[position].categoryName
        Log.d("CategoryAdapter", holder.binding.categoryName.text.toString())
        if (categoryList[position].isSelected) holder.binding.categoryButton.setBackgroundResource(R.drawable.category_button_selected)
        else holder.binding.categoryButton.setBackgroundResource(R.drawable.category_button_border)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    interface CategoryCallback {
        fun onCategoryClick(categoryName: String)
    }
}
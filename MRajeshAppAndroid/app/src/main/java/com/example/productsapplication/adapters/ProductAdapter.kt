package com.example.productsapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.example.productsapplication.R
import com.example.productsapplication.databinding.ActivityProductCardBinding
import com.example.productsapplication.models.Product

class ProductAdapter(private val mContext: Context, private val productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ActivityProductCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val prodCardItem = ActivityProductCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(prodCardItem)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        Glide.with(mContext).asBitmap()
            .load(productList[position].imageUrl)
            .into(BitmapImageViewTarget(holder.binding.image))
        holder.binding.productName.text = productList[position].productName
        holder.binding.productPrice.text = productList[position].price.toString()
       // holder.binding.productPrice.text =  mContext.getString(R.string.product_price, productList[position].price)
    }
}
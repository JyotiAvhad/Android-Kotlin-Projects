package com.example.neostore.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neostore.R
import com.example.neostore.view.fragments.ProductListModel
import kotlinx.android.synthetic.main.item_list_layout.view.*

class RecyclerGridAdapter(var prodNameList: List<ProductListModel>) : RecyclerView.Adapter<RecyclerGridAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val productListModel = prodNameList[position]
        holder.productImg.setImageResource(productListModel.pImage)
        holder.productName.text = productListModel.pName
        holder.productPrice.text = productListModel.pPrice.toString()

    }

    override fun getItemCount(): Int {
        return prodNameList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productImg: ImageView = itemView.iv_product_img
        var productName: TextView = itemView.tv_product_name
        var productPrice: TextView = itemView.tv_product_price
    }


}



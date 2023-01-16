package com.example.neostore.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.neostore.R
import com.example.neostore.view.activities.ProductDetailActivity
import com.example.neostore.view.model.ProductListModel
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
        var context = holder.itemView.context
        holder.productCard.setOnClickListener {
            val intent = Intent(context,ProductDetailActivity::class.java)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return prodNameList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productImg: ImageView = itemView.iv_product_img
        var productName: TextView = itemView.tv_product_name
        var productPrice: TextView = itemView.tv_product_price
        var productCard: CardView = itemView.cv_item_img
    }


}


